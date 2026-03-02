package impl;

import contracts.BillLine;
import contracts.CsvBillWriter;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CsvBillWriterImpl implements CsvBillWriter {
    @Override
    public void write(String path, ArrayList<BillLine> lines, BigDecimal total, int errors) throws IOException {

        try (FileWriter fw = new FileWriter(path)) {
            for (BillLine line : lines) {
                fw.append(line.toString()).append("\n");
            }
            fw.append(String.format("TOTAL;;;;%s", total.toString())).append("\n");
            fw.append(String.format("ERRORS;;;;%d", errors)).append("\n");
        }
    }
}
