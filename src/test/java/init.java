import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

class initTest
{
    @Test
    void init()
    {
        Init in0 = new Init();
        Init in1 = new Init();

        assertAll(
                ()-> assertEquals(0,in0.id),
                ()-> assertEquals(0,in1.id)
        );
    }
}
