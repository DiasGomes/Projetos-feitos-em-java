public class ArvoreSBB {

    // Classe No com um item e dois ponteiros para esquerda e direita
    private static class No {
        Item reg;
        No esq, dir;
        byte incE, incD;
    }

    private static final byte Horizontal = 0;
    private static final byte Vertical = 1;
    private No raiz;
    private boolean propSBB;
    
    // inicializando uma árvore;
    public ArvoreSBB () {
       this. raiz = null;this.propSBB = true;
    }
    // transformação esquerda-esquerda
    // sob com o do meio desce com os demais
    // braço da direita do meio vira braço da esquerda do maior
    private No ee(No ap) {
            No ap1 = ap.esq;
            ap.esq = ap1.dir;
            ap1.dir = ap;
            ap1.incE = Vertical;
            ap.incE = Vertical;
            ap = ap1;
            return ap;
        }
    // transformação esquerda-direita
    // sob com o do meio desce com os demais
    // braço da esquerda do meio vira braço da direita do menor
    // braço da direita do meio vira braço da esquerda do maior
    private No ed(No ap) {
        No ap1 = ap.esq;
            No ap2 = ap1.dir;
            ap1.incD = Vertical;
            ap.incE = Vertical;
            ap1.dir = ap2.esq;
            ap2.esq = ap1;
            ap.esq = ap2.dir;
            ap2.dir = ap;
            ap = ap2;
            return ap;
    }
    // transformação direita-direita 
    // sob com o do meio desce com os demais
    // braço da esquerda do meio vira braço da direita do menor
    private No dd(No ap) {
        No ap1 = ap.dir;
            ap.dir = ap1.esq;
            ap1.esq = ap;
            ap1.incD = Vertical;
            ap.incD = Vertical;
            ap = ap1;
            return ap;
    }
    // transformação direita-esquerda
    // sob com o do meio desce com os demais
    // braço da esquerda do meio vira braço da direita do menor
    // braço da direita do meio vira braço da esquerda do maior
    private No de(No ap) {
        No ap1 = ap.dir;
        No ap2 = ap1.esq;
        ap1.incE = Vertical;
        ap.incD = Vertical;
        ap1.esq = ap2.dir;
        ap2.dir = ap1;
        ap.dir = ap2.esq;
        ap2.esq = ap;
        ap = ap2;
        return ap;
    }

    public Item pesquisa (Item reg) {
        return this.pesquisa (reg ,this. raiz); 
    }
    
    public void insere (Item reg) {
       this. raiz = insere (reg , null ,this. raiz , true);
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

    private No insere (Item reg , No pai , No filho , boolean filhoEsq) {
        // insere se a folha estiver vazia
        if(filho == null) {
            filho = new No ();
            filho.reg = reg;
            filho.incE = Vertical;
            filho.incD = Vertical;
            filho.esq = null;
            filho.dir = null;
            if(pai != null)
                if(filhoEsq) pai.incE = Horizontal;
                else pai.incD = Horizontal;
            this.propSBB = false;
        }else if(reg.compara (filho.reg) < 0) {
            // continua a inserção na árvore da esquerda por ser menor
            filho.esq = insere (reg , filho ,filho.esq, true);
            if(!this.propSBB)
                // verifica se a mais de um elemento na horizontal
                if(filho.incE == Horizontal) {
                    if(filho.esq. incE == Horizontal) {
                        filho = this.ee (filho); // transformação esquerda-esquerda
                        if(pai != null)
                            if(filhoEsq) pai.incE=Horizontal;
                            else pai.incD=Horizontal;
                    }else if(filho.esq.incD == Horizontal) {
                        filho = this.ed (filho); // transformação esquerda-direita
                        if(pai != null)
                            if(filhoEsq) pai.incE=Horizontal;
                            else pai.incD=Horizontal;
                    }
                }else 
                    this.propSBB = true;
        }else if(reg.compara (filho.reg) > 0) {
            // continua a inserção na árvore da direita por ser maior
            filho.dir = insere (reg , filho ,filho.dir , false);
            if(! this.propSBB)
                // verifica se a mais de um elemento na horizontal
                if(filho.incD == Horizontal) {
                    if(filho.dir.incD == Horizontal) {
                        filho = this.dd (filho); // transformação direita-direita
                        if(pai != null)
                            if(filhoEsq) pai.incE=Horizontal;
                            else pai.incD=Horizontal;
                    }else if(filho.dir.incE == Horizontal) {
                        filho = this.de (filho); // transformação direita-esquerda
                        if(pai != null)
                            if(filhoEsq) pai.incE=Horizontal;
                            else pai.incD=Horizontal;
                    }
                }else
                    this.propSBB = true;
        }else {
            // Registro ja existente
            //System. out.println ("Erro : Registro ja existente ");
            this.propSBB = true;
        }
        return filho;
    }

}

