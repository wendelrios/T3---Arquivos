package t3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;

public class Principal {

	public static void main(String[] args) throws IOException{
		
		String saida = "/Users/wendel/jee-eclipse-workspace/TRABALHO3/src/t3/ordenado.csv";
		String bolsa = "/Users/wendel/jee-eclipse-workspace/TRABALHO3/src/t3";
		File f = new File(bolsa);
		
		ArrayList<Beneficiario> mes;
		
		mes = ordenarArquivo(f);
		
		BufferedWriter br = new BufferedWriter(new FileWriter(saida));
        StringBuilder sb = new StringBuilder();
        
        for(Beneficiario b: mes)
        {
            for(String s : b.escreveBeneficiarioLinha())
            {
                sb.append(s);
                sb.append(";");
            }
            sb.append("\n");  
        }
        br.write(sb.toString());
        br.close();

        System.out.println(mes.get(9).escreveBeneficiarioLinha()[3]);
         
         
    }
}
	
	private static ArrayList<Beneficiario> ordenarArquivo(File arquivo) throws IOException{ 

    ArrayList<Beneficiario> listaBeneficiarios = new ArrayList<Beneficiario>();

    Beneficiario b;
    RandomAccessFile rf = new RandomAccessFile(arquivo, "r");
    rf.seek(0);

    String linha = rf.readLine();

    if (linha == null) {
        return new ArrayList<Beneficiario>();
    }

    linha = rf.readLine();

    while (linha != null) {

        b = new Beneficiario();
        b.leBeneficiario(linha);
        listaBeneficiarios.add(b);

        linha = rf.readLine();

    }
    rf.close();

    Collections.sort(listaBeneficiarios, new ComparaComBeneficiario());

    return listaBeneficiarios;
}		



