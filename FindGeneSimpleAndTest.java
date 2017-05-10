
/**
 * Write a description of class FindGeneSimpleAndTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FindGeneSimpleAndTest
{
    public String findGeneSimple(String dna ) {
        // start codon is "ATG"
        // stop codon is "TAA"
        
        String result = "";
        int startIndex = dna.indexOf("ATG");
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        result = dna.substring(startIndex, stopIndex+3);
        
        return result;
    }
}
