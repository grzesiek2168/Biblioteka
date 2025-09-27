import io
import requests
from PyPDF2 import PdfReader
from fpdf import FPDF
from flask import Flask, render_template, request, send_file

# Inicjalizacja aplikacji Flask
app = Flask(__name__)

# Stały adres URL dla darmowego API DeepL
DEEPL_API_URL = "https://api-free.deepl.com/v2/translate"

class PDF(FPDF):
    def header(self):
        pass

    def footer(self):
        pass

def translate_text(text, api_key):
    """Wysyła tekst do API DeepL w celu tłumaczenia."""
    params = {
        "auth_key": api_key,
        "text": text,
        "source_lang": "EN",
        "target_lang": "PL"
    }
    response = requests.post(DEEPL_API_URL, data=params)
    if response.status_code == 200:
        return response.json()["translations"][0]["text"]
    else:
        # Rzucenie wyjątku z komunikatem błędu z API
        raise Exception(f"Błąd API DeepL: {response.status_code} - {response.text}")

@app.route("/")
def index():
    """Wyświetla główną stronę z formularzem do wysyłania plików."""
    return render_template("index.html")

@app.route("/translate", methods=["POST"])
def translate_pdf():
    """
    Obsługuje proces tłumaczenia: odbiera plik PDF i klucz API,
    ekstrahuje tekst, tłumaczy go i generuje nowy plik PDF.
    """
    # Sprawdzenie, czy plik został przesłany
    if 'pdf_file' not in request.files:
        return "Nie znaleziono pliku w zapytaniu!", 400

    file = request.files['pdf_file']
    api_key = request.form.get('api_key')

    # Sprawdzenie, czy nazwa pliku nie jest pusta
    if file.filename == '':
        return "Nie wybrano żadnego pliku!", 400

    # Sprawdzenie, czy podano klucz API
    if not api_key:
        return "Klucz API DeepL jest wymagany!", 400

    if file and file.filename.endswith('.pdf'):
        try:
            # --- Krok 1: Ekstrakcja tekstu z oryginalnego PDF ---
            pdf_stream = io.BytesIO(file.read())
            reader = PdfReader(pdf_stream)
            original_text = ""
            for page in reader.pages:
                original_text += page.extract_text() + "\n"

            if not original_text.strip():
                return "Nie udało się wyodrębnić tekstu z pliku PDF. Może on zawierać obrazy zamiast tekstu.", 400

            # --- Krok 2: Tłumaczenie wyekstrahowanego tekstu ---
            translated_text = translate_text(original_text, api_key)

            # --- Krok 3: Tworzenie nowego PDF z przetłumaczonym tekstem ---
            pdf = PDF()
            pdf.add_page()
            # Dodanie czcionki obsługującej polskie znaki (UTF-8)
            pdf.add_font("DejaVu", "", "DejaVuSans.ttf", uni=True)
            pdf.set_font("DejaVu", "", 12)

            # Użycie multi_cell do automatycznego łamania wierszy
            pdf.multi_cell(0, 10, translated_text)

            # --- Krok 4: Przygotowanie pliku do wysłania ---
            pdf_output = io.BytesIO()
            pdf.output(pdf_output)
            pdf_output.seek(0)

            return send_file(
                pdf_output,
                as_attachment=True,
                download_name=f"przetlumaczony_{file.filename}",
                mimetype='application/pdf'
            )

        except Exception as e:
            # Zwrócenie szczegółowego błędu użytkownikowi
            return f"Wystąpił błąd: {e}", 500

    return "Nieprawidłowy format pliku. Proszę przesłać plik PDF.", 400

if __name__ == "__main__":
    # Uruchomienie aplikacji w trybie debugowania
    app.run(debug=True)