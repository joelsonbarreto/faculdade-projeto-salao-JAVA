package entity;

public class Servicos {
    private String nomeservico;
    private float valorservico;
    
    public Servicos(String nomeservico, float valorservico) {

        this.nomeservico = nomeservico;
        this.valorservico = valorservico;
    }
    public String getNomeServico() {
        return nomeservico;
    }

    public float getValorServico() {
        return valorservico;
    }
 
    public void setNomeServico(String nomeservico){
        this.nomeservico = nomeservico;
    }
    public void setValorServico(float valorservico){
        this.valorservico = valorservico;
    }
}
//     public String toString() {
//         return "Produto: " + nomeServico + "\nPreço " + valorServico + "\n";
//     }

//     public static void salvarServico(Servicos servicos, String caminhoArquivo) {
//         try {
//             BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true));
//             writer.write(servicos.toString());
//             writer.close();
//             System.out.println("Serviço salvo em arquivo de texto com sucesso!");
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

// }
