package cn.yy.javaservicev2.dto.relation;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class CusRelationBody  implements Serializable {
    List<CusEntry> entries;
}
