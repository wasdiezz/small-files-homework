package impl;

import contracts.CsvProductReader;
import contracts.ProductLine;
import contracts.ReadResult;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvProductReaderImpl implements CsvProductReader {
//    public static final Path PATH = Path.of("C:\\Users\\vkave\\IdeaProjects\\eneric\\src\\sources\\products.csv");
    public static final int NAME_INDEX = 0;
    public static final int QUANTITY_INDEX = 1;
    public static final int PRICE_INDEX = 2;
    private static int errors;

    @Override
    public ReadResult<ProductLine> read(String path) throws IOException {
        ArrayList<ProductLine> products = new ArrayList<>();
        List<String> lines = null;

        try {
            lines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("something went wrong with reading the file" + e.getMessage());
        }

        for (String line : lines) {
            String[] parts = line.split(";");
            if (line.trim().startsWith("#") || parts.length != 3) {
                errors++;
                continue;
            }
            ProductLineImpl product = new ProductLineImpl(
                    parts[NAME_INDEX].trim(),
                    Integer.parseInt(parts[QUANTITY_INDEX].trim()),
                    new BigDecimal(parts[PRICE_INDEX].trim())
            );
            products.add(product);
        }
        return new ReadResultImpl<>(products, errors);
    }
}
