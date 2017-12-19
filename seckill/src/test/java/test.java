import com.lzk.entity.Seckill;
import org.junit.Test;
import org.qingpu.Utils.sql.MybatisCRUDGenerator;

public class test {
    @Test
    public void aaa(){
        MybatisCRUDGenerator mybatisCRUDGenerator = new MybatisCRUDGenerator(Seckill.class);
        mybatisCRUDGenerator.generateQueryById();
    }
}
