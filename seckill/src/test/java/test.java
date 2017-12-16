import com.lzk.entity.Seckill;
import com.lzk.entity.SuccessKilled;
import org.junit.Test;
import org.qingpu.Utils.sql.MybatisCRUDGenerator;

public class test {
    @Test
    public void aaa(){
        MybatisCRUDGenerator mybatisCRUDGenerator = new MybatisCRUDGenerator(Seckill.class);
        mybatisCRUDGenerator.generateQueryById();
    }
}
