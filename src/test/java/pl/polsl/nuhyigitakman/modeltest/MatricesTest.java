package pl.polsl.nuhyigitakman.modeltest;

import org.junit.jupiter.api.*;
import pl.polsl.nuhyigitakman.model.Matrices;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("Disabled until all of the method bodies get filled.")
public class MatricesTest {
    @Test
    public void testGetPlot(){
        Matrices matrices = new Matrices();
        List<Character> plot = new ArrayList<>();
        assertSame(matrices.getPlot(), plot);
    }
    @Test
    public void testGetPlotTwo(){
        Matrices matrices = new Matrices();
        List<Character> plot = new ArrayList<>();
        assertSame(matrices.getPlotTwo(), plot);
    }
    @Test
    public void testGetPlotThree(){
        Matrices matrices = new Matrices();
        List<Character> plot = new ArrayList<>();
        assertSame(matrices.getPlotThree(), plot);
    }
    @Test
    public void testGetRemove(){
        Matrices matrices = new Matrices();
        char remove = 'Q';
        assertSame(matrices.getRemove(), remove);
    }
    @Test
    public void testPlotAlphabets(){
        //perform assertion for plot alphabets
    }
    @Test
    public void testPlotKey(){
        //perform assertion for plot key
    }
    @Test
    public void testRandomizeKey(){
        //perform assertion for randomize key
    }
}
