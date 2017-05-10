
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
         if (startIndex == -1 || stopIndex == -1) {
            return "not found here";
        }
        result = dna.substring(startIndex, stopIndex+3);
       
        return result;
    }
    
    public void testfindGeneSimple() {
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        
        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        
        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        
        // No start gene case 
        dna = "TTATAA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        
        
         dna = "TATGTATATCG";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
    }
}
