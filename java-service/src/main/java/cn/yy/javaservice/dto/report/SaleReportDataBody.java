package cn.yy.javaservice.dto.report;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SaleReportDataBody  implements Serializable {
    private List<SaleEntry> entries;
}
