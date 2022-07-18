import User.User;
import UserGenerator.UserGenerator;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.text.pdf.BaseFont;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        int userInput;
        System.out.println("Введите количество пользователей (от 1 до 30): ");
        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);
                userInput = scanner.nextInt();
                if (userInput >= 1 && userInput <= 30) break;
                System.out.println("Число пользователей равно 0 или больше 30 попробуйте снова");
            }
            catch (Exception InputMismatchException) {
                System.out.println("Введите число");
            }
        }
        
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter("./pdf_output.pdf));
        String path = pdfDoc.getPath();                                                   
        pdfDoc.setDefaultPageSize(PageSize.A4.rotate());
        Document doc = new Document(pdfDoc);
        PdfFontFactory.register("/fonts/FreeSans.ttf");
        PdfFont font = PdfFontFactory.createFont("/fonts/FreeSans.ttf", "CP1251", BaseFont.EMBEDDED);
        Table table = new Table(14);
        doc.setFont(font);
        doc.setFontSize(8);
        table.addCell(new Cell().add("Имя"));
        table.addCell(new Cell().add("Фамилия"));
        table.addCell(new Cell().add("Отчество"));
        table.addCell(new Cell().add("Возраст"));
        table.addCell(new Cell().add("Пол"));
        table.addCell(new Cell().add("Дата рождения"));
        table.addCell(new Cell().add("Место рождения"));
        table.addCell(new Cell().add("Индекс"));
        table.addCell(new Cell().add("Страна"));
        table.addCell(new Cell().add("Область"));
        table.addCell(new Cell().add("Город"));
        table.addCell(new Cell().add("Улица"));
        table.addCell(new Cell().add("Дом"));
        table.addCell(new Cell().add("Квартира"));

        for (int i = 0; i < userInput; i++) {
                    User newUser = UserGenerator.generateUser();
                    table.addCell(new Cell().add(newUser.userFirstName));
                    table.addCell(new Cell().add(newUser.userLastName));
                    table.addCell(new Cell().add(newUser.userPatronymic));
                    table.addCell(new Cell().add(String.valueOf(newUser.userAge)));
                    table.addCell(new Cell().add(newUser.userGender));
                    table.addCell(new Cell().add(String.valueOf(newUser.userDateOfBirth)));
                    table.addCell(new Cell().add(newUser.userPlaceOfBirth));
                    table.addCell(new Cell().add(newUser.userPostcode));
                    table.addCell(new Cell().add(newUser.userCountry));
                    table.addCell(new Cell().add(newUser.userRegion));
                    table.addCell(new Cell().add(newUser.userCity));
                    table.addCell(new Cell().add(newUser.userStreet));
                    table.addCell(new Cell().add(String.valueOf(newUser.userHouseNumber)));
                    table.addCell(new Cell().add(String.valueOf(newUser.userFlatNumber)));
        }
        doc.add(table);
        doc.close();
        System.out.println("Файл создан.);
    }
}
