import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(rnaSequence);
        if(sb.length() > 3) {
        	for(int i = 3; i < sb.length(); i+=4) {
            	sb.insert(i, '-');        	
            }
        	res = Arrays.asList(sb.toString().split("-"));
        }else {
        	res.add(rnaSequence);
        }
        return changeCodonsForProtein(res);
    }
    
    List<String> changeCodonsForProtein(List<String> list){
    	List<String> res = new ArrayList<String>();
    	for(String s: list) {
			if(s.equals("AUG")){
				res.add("Methionine");
			}else if(s.equals("UUU") || s.equals("UUC")) {
				res.add("Phenylalanine");
			}else if(s.equals("UUA") || s.equals("UUG")) {
				res.add("Leucine");
			}else if(s.equals("UCU") || s.equals("UCC") || s.equals("UCA") || s.equals("UCG")) {
				res.add("Serine");
			}else if(s.equals("UAU") || s.equals("UAC")) {
				res.add("Tyrosine");
			}else if(s.equals("UGU") || s.equals("UGC")) {
				res.add("Cysteine");
			}else if(s.equals("UGG")) {
				res.add("Tryptophan");
			}else if(s.equals("UAA") || s.equals("UAG") || s.equals("UGA")) {	
				break;
			}
    	}
    	return res;
    }

}