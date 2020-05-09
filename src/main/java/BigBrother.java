import java.util.*;

public class BigBrother {

    Map<String,Integer> paredao = new HashMap<String,Integer>();

    public void adicionaBrother(String brother){
        paredao.put(brother,0);
    }

    public Map<String,Integer> listaParedao(){
        Map<String,Integer> res = new HashMap<String,Integer>();
        if (paredao.size() >= 2) {
            res = paredao;
        } else {
            System.out.println("Tem menos de 2 candidatos no paredão, paredão ainda não está pronto!");
        }
        return res;
    }

    public Map<String,Integer> getParedao(){
        return paredao;
    }

    public void votarBrother(String brother){
        paredao.put(brother,paredao.get(brother)+1);
    }

    public String brotherEliminado(){
        String res = "";
        Map<String,Integer> paredaoAux = getParedao();

        if (paredaoAux.size() == 0) {
            res = "Nenhum brother cadastrado";
        } else {
            Iterator it = paredaoAux.entrySet().iterator();
            String name = "";
            Integer biggestValue = 0;
            Boolean unico = true;

            while (it.hasNext()) {
                Map.Entry brow = (Map.Entry) it.next();
                if ((Integer) brow.getValue() > biggestValue) {
                    name = (String) brow.getKey();
                    biggestValue = (Integer) brow.getValue();
                    unico = true;
                } else if ((Integer) brow.getValue() == biggestValue) {
                    unico = false;
                }
            }

            if (biggestValue == 0) {
                res = "Brothers sem votos ainda!";
            } else {
                if (unico) {
                    res = "Brother eliminado => " + name;
                } else {
                    res = "Brothers empatados, reabra a votação!";
                }
            }
        }
        return res;
    }
}
