package entity;

public class Clientes {
    private String nomecliente;
    private String cpfcliente;
    private String enderecocliente;
    private String telefonecliente;    

    public Clientes(String nomecliente, String cpfcliente, String enderecocliente, String telefonecliente) {
        this.nomecliente = nomecliente;
        this.cpfcliente = cpfcliente;
        this.enderecocliente = enderecocliente;
        this.telefonecliente = telefonecliente;        
    }

    public Clientes(){
        this.nomecliente = "";
        this.cpfcliente = "";
        this.enderecocliente = "";
        this.telefonecliente = ""; 
    }
    
    public String getNome(){
        return nomecliente;
    }

    public String getCpf() {
        return cpfcliente;
    }

    public String getEndereco() {
        return enderecocliente;
    }

    public String getTelefone() {
        return telefonecliente;
    }

   
    public void setNome(String nomecliente) {
        this.nomecliente = nomecliente;
    }
    public void setCpf(String cpfcliente) {
        this.cpfcliente = cpfcliente;
    }

    public void setEndereco(String enderecocliente) {
        this.enderecocliente = enderecocliente;
    }

    public void setTelefone(String telefonecliente) {
        this.telefonecliente = telefonecliente;
    }

    

    // public String toString() {
    //     return "Nome: " + nome + "\nEndereço: " + endereco + "\nTelefone: " + telefone + "\nCPF: " + cpf +"\n";
    // }

    // public static void salvarCliente(Clientes cliente, String caminhoArquivo) {
    //     try {
    //         BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true));
    //         writer.write(cliente.toString());
    //         writer.close();
    //         System.out.println("Cliente salvo em arquivo de texto com sucesso!");
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
}
