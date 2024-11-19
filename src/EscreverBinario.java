import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscreverBinario {
    public static void main(String[] args) {
        String caminhoArquivo = "dados.bin";

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(caminhoArquivo))) {
            out.writeInt(1);          // quantidade_disciplinas
            out.writeUTF("2024");
            out.writeUTF("2");
            out.writeUTF("Banco de Dados");
            out.writeUTF("FACOM49080");
            out.writeUTF("60");
            out.writeUTF("Ilmerio Reis");
            out.writeUTF("FACOM");
            out.writeUTF("15/12/2024");
            out.writeUTF("16532214298");
            out.writeUTF("21/02/1969");
            out.writeInt(5); //12
            out.writeUTF("META");
            out.writeUTF("76");
            out.writeUTF("Joao Alberto");
            out.writeUTF("16532214253");
            out.writeUTF("13/12/1998");
            out.writeUTF("Microsoft");
            out.writeUTF("75");
            out.writeUTF("Joao Rodrigo Andrade");
            out.writeUTF("16532214253");
            out.writeUTF("14/02/1996");
            out.writeUTF("Algar Telecom");
            out.writeUTF("85");
            out.writeUTF("Maria Bertanha");
            out.writeUTF("16532214253");
            out.writeUTF("03/07/1998");
            out.writeUTF("NeoSpace");
            out.writeUTF("80");
            out.writeUTF("Marie Curie");
            out.writeUTF("16532214253");
            out.writeUTF("01/12/1996");
            out.writeUTF("ITAU UNIBANCO");
            out.writeUTF("80");
            out.writeUTF("Alan Turing");
            out.writeUTF("16532214253");
            out.writeUTF("12/06/1994");
            out.writeInt(2);
            out.writeUTF("Transformer applied in speech recognition");
            out.writeUTF("92");
            out.writeUTF("Tri Dao");
            out.writeUTF("18231294221");
            out.writeUTF("11/02/1989");
            out.writeUTF("Transformer applied in recognition of child porn pictures");
            out.writeUTF("90");
            out.writeUTF("Maria Rita");
            out.writeUTF("18231294224");
            out.writeUTF("11/02/1995");





            System.out.println("Dados gravados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gravar o arquivo: " + e.getMessage());
        }
    }
}