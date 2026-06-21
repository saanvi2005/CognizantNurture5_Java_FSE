// Exercise 2: Factory Method Pattern
// Scenario: A document management system that creates Word, PDF, and Excel documents.

// ---- Product hierarchy ----
interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() {
        System.out.println("Opening a Word document (.docx)");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening a PDF document (.pdf)");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening an Excel document (.xlsx)");
    }
}

// ---- Creator hierarchy ----
abstract class DocumentFactory {
    // Factory Method
    public abstract Document createDocument();

    // Template-style helper that uses the factory method
    public Document newDocument() {
        Document doc = createDocument();
        System.out.println("Document created by " + this.getClass().getSimpleName());
        return doc;
    }
}

class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// ---- Test class (main) ----
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document word = wordFactory.newDocument();
        word.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdf = pdfFactory.newDocument();
        pdf.open();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excel = excelFactory.newDocument();
        excel.open();
    }
}
