package io.github.devdevx.mm.mappers;

import io.github.devdevx.mm.dtos.SourceOne;
import io.github.devdevx.mm.dtos.SubSourceOne;
import io.github.devdevx.mm.dtos.TargetOne;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SourceMapperTests {

    @Test
    void flatter_source() {
        var m = new SourceMapper();
        var s = new SourceOne("one", "two", "three", new SubSourceOne("four", "five", "six"));
        var t = m.flatter(s);
        assertEquals(s.getValueOne(), t.getValueOne());
        assertEquals(s.getValueTwo(), t.getValueTwo());
        assertEquals(s.getValueThree(), t.getValueThree());
        assertEquals(s.getSubSourceOne().getValueFour(), t.getValueFour());
        assertEquals(s.getSubSourceOne().getValueFive(), t.getValueFive());
        assertEquals(s.getSubSourceOne().getValueSix(), t.getValueSix());
    }

    @Test
    void partial_update_target() {
        var m = new SourceMapper();
        var s = new SourceOne("one", "two", "three", new SubSourceOne("four", "five", "six"));
        var t = new TargetOne("1", "2", "3", "4", "5", "6");
        m.partialUpdate(s, t);
        assertEquals("1", t.getValueOne());
        assertEquals(s.getValueTwo(), t.getValueTwo());
        assertEquals(s.getValueThree(), t.getValueThree());
        assertEquals("4", t.getValueFour());
        assertEquals(s.getSubSourceOne().getValueFive(), t.getValueFive());
        assertEquals(s.getSubSourceOne().getValueSix(), t.getValueSix());
    }
}