
package atividade01uc10.model;


public class Filme {
        private int id;
        private String nome;
        private String dataLancamento;
        private String categoria;

    public Filme(int id, String nome, String dataLancamento, String categoria) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
    }

    public Filme() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    // aaaa-mm-dd
    public static String converterParaSQL(String dataAntiga){
      String[] partesData = dataAntiga.split("/");
      String dataNova = partesData[2] + "-" + partesData[1] + "-" + partesData[0];
      return dataNova;
    }
    
    //dd-mm-aaaa
    public static String converterParaJava(String dataAntiga){
      String[] partesData = dataAntiga.split("-");
      String dataNova = partesData[2] + "/" + partesData[1] + "/" + partesData[0];
      return dataNova;  
    }
}
