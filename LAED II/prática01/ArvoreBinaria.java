public class ArvoreBinaria {

    // Classe No com um item e dois ponteiros para esquerda e direita
    private static class No {
        Item reg;
        No esq, dir;
    }

    private No raiz;

    // inicializando uma árvore;
    public ArvoreBinaria(){
        this.raiz = null;
    }

    public Item pesquisa(Item reg){
        return this.pesquisa(reg, this.raiz);
    }

    public void insere(Item reg){
        this.raiz = this.insere(reg, this.raiz);
    }

    private Item pesquisa(Item reg, No p){
        if(p == null) 
            return null;                    //registro não encontrado
        else if(reg.compara(p.reg) < 0){
            return pesquisa(reg, p.esq);    // se é menor o registro deve estar na esquerda
        }else if(reg.compara(p.reg) > 0){
            return pesquisa(reg, p.dir);    // se é maior o registro deve estar na direita
        }else 
            return p.reg;                   // registro encontrado
    }

    private No insere(Item reg, No p){
        if(p == null){
            p = new No();       // cria um novo No caso não exista
            p.reg = reg;        // recebe o Item e cria ponteiros nulos
            p.esq = null;
            p.dir = null;
        }else if(reg.compara(p.reg) < 0){
            p.esq = insere(reg, p.esq);     // se é menor o registro deve ser ficar na esquerda
        }else if(reg.compara(p.reg) > 0){
            p.dir = insere(reg, p.dir);     // se é menor o registro deve ser ficar na direita
        }
        //else System.out.println("ERRO: Registro já existente");
        return p;
    }

}
