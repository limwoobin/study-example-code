package me.whiteship.inflearnthejavatest.study;

import me.whiteship.inflearnthejavatest.domain.Study;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudyTest {

//    @BeforeEach
//    void init() {
//        System.out.println("init");
//    }

    @DisplayName("테스트 메소드 ##")
    @Test
    void test() {
        System.out.println("test ###");
    }

    @DisplayName("반복 테스트")
    @RepeatedTest(value = 10 , name = "{displayName} {currentRepetition}/{totalRepetitions}")
    void repeatTest() {
        System.out.println("repeat");
    }

    @DisplayName("파라미터 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가" , "많이" , "추워지고" , "있네요"})
//    @EmptySource
//    @NullSource
    void parameterizedTest(String message) {
        System.out.println(message);
    }

    @DisplayName("파라미터 테스트2")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(ints = {10 , 20 , 40})
    void parameterizedTest2(int limit) {
        System.out.println(limit);
    }

    @DisplayName("파라미터 테스트3")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(ints = {10 , 20 , 40})
    void parameterizedTest3(@ConvertWith(StudyConverter.class) Study study) {
        System.out.println(study.getLimitCount());
    }

    static class StudyConverter extends SimpleArgumentConverter {

        @Override
        protected Object convert(Object o, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class , targetType , "Can only convert to Study");
            return new Study(Integer.parseInt(o.toString()));
        }
    }

    @DisplayName("파라미터 테스트4")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"10 , '자바 스터디'" , "20 , 스프링"})
    void parameterizedTest4(@AggregateWith(StudyAggregator.class) Study study) {
        System.out.println(study.getLimitCount() + " , " + study.getName());
    }

    static class StudyAggregator implements ArgumentsAggregator {

        @Override
        public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            return new Study(accessor.getInteger(0) , accessor.getString(1));
        }
    }
}
