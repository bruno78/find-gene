
/**
 * Write a description of class FindGeneSimpleAndTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FindGeneSimpleAndTest
{
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon){
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            if ((currIndex - startIndex) % 3 == 0) {
                return currIndex;
            }
            else {
                currIndex = dnaStr.indexOf(stopCodon, currIndex+1);
            }
        }
        return dnaStr.length();
    }
    
    public String findGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int minIndex = Math.min(taaIndex, Math.min(tgaIndex, tagIndex));
        if (minIndex == dna.length()){
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }
    
    public void testFindStop() {
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna, 0, "TAA");
        if (dex != 9) System.out.println("error on 9");
        dex = findStopCodon(dna,9,"TAA");
        if (dex != 21) System.out.println("error on 21");
        dex = findStopCodon(dna,1,"TAA");
        if (dex != 26) System.out.println("error on 26");
        dex = findStopCodon(dna,0,"TAG");
        if (dex != 26) System.out.println("error on 26");
        System.out.println("Test done!");
        
    }
    
    public void testfindGene() {
        
        // First case: There's an ATG but no stop codon. No gene
        System.out.println("First case: There's an ATG but no stop codon. No gene");
        String dna = "TATGTATATCG";
        System.out.println("DNA strand is " + dna);
        String gene = findGene(dna);
        System.out.println("Gene is " + gene);
        
        // Second case: Stop codon is TAA. There's a Gene
        System.out.println("Second case: Stop codon is TAA. There's a Gene");
        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene + "\n");
        
        // Third case: Stop Codon is TAG. There's a Gene
        System.out.println("Third case: Stop Codon is TAG. There's a Gene");
        dna = "ATCCTATGCTTCGGCTGCTCTAGTATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene + "\n");
        
        // Forth case: No start gene case 
        System.out.println("Forth case: No start gene case");
        dna = "TTATAA";
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene + "\n");
        
        // Fifth case: Stop Codon is TGA. There's a Gene
        System.out.println("Fifth case: Stop Codon is TGA. There's a Gene");
        dna = "ATCCTATGCTTCGGTGACTCTAGTATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene + "\n");
        
        // Sixth case: There are start and stop codons but they aren't multiple of 3
        System.out.println("Sixth case: There are start and stop codons but they aren't multiple of 3");
        dna = "AACATGAATTCGAAGTTAGATTACGAACG";
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene + "\n");
        
    }
}
