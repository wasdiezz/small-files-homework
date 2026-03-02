//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("а");
        String path ="C:\\Users\\vkave\\IdeaProjects\\small-files-homework\\src\\sources\\products.csv";
        CsvProductReader csvProductReader = new CsvProductReaderImpl();
        ReadResult<ProductLine> readResult = csvProductReader.read(path);

        BillCalculator billCalculator = new BIllCalculatorImpl();

        BillResult<BillLine> billResult = billCalculator.calculate(readResult.getItems());

        CsvBillWriter csvBillWriter = new CsvBillWriterImpl();
        String outputPath = "C:\\Users\\vkave\\IdeaProjects\\small-files-homework\\src\\end\\Bill.csv";

        csvBillWriter.write(outputPath, billResult.getLines(),  billResult.getTotal(), readResult.getErrorCount());

    }
}
