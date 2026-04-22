package wo1261931780.testMybatisFlex.domain;


import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
*Created by Intellij IDEA.
*Project:test-MybatisFlex
*Package:wo1261931780.testMybatisFlex.domain
*@author liujiajun_junw
*@Date 2023-11-21-00  星期日
*@Description 
*/

@Schema
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "test_technical.tb_account")
public class TbAccount implements Serializable {
    @Id(value = "id", keyType = KeyType.Sequence)
    @Schema(description = "")
    private Integer id;

    @Column(value = "user_name")
    @Schema(description = "")
    private String userName;

    @Column(value = "age")
    @Schema(description = "")
    private Integer age;

    @Column(value = "birthday")
    @Schema(description = "")
    private Date birthday;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USER_NAME = "user_name";

    public static final String COL_AGE = "age";

    public static final String COL_BIRTHDAY = "birthday";
}
