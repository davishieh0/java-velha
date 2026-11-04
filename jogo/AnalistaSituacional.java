package jogo;

public class AnalistaSituacional
{
    private Tabuleiro tabDoJogo;

    public AnalistaSituacional (Tabuleiro tab) throws Exception
    {
        // colocar tab em tabDoJogo
        if (tab==null) throw new Exception ("Tabuleiro ausente");

        this.tabDoJogo=tab; // sem clone: tem que ser o mesmo tabuleiro do jogo
    }

    private Marca getMarcaVencedoraNaSequencia (int l0, int c0, int l1, int c1, int l2, int c2) throws Exception
    {
        Marca retorno = this.tabDoJogo.getMarcaNaPosicao(l0,c0);

        if (retorno==null) return null;
        if (!retorno.equals(this.tabDoJogo.getMarcaNaPosicao(l1,c1))) return null;
        if (!retorno.equals(this.tabDoJogo.getMarcaNaPosicao(l2,c2))) return null;

        return retorno;
    }

    public Marca getMarcaDoVencedor ()
    {
        // descobrir se ha um vencedor e retornar
        // a marca dele; retornara null, quando
        // nao houver vencedor
        Marca retorno=null;

        try
        {
            for (int i=0; i<3 && retorno==null; i++)
            {
                retorno=this.getMarcaVencedoraNaSequencia(i,0, i,1, i,2); // linha i
                if (retorno==null)
                    retorno=this.getMarcaVencedoraNaSequencia(0,i, 1,i, 2,i); // coluna i
            }

            if (retorno==null)
                retorno=this.getMarcaVencedoraNaSequencia(0,0, 1,1, 2,2); // diagonal principal

            if (retorno==null)
                retorno=this.getMarcaVencedoraNaSequencia(0,2, 1,1, 2,0); // diagonal secundaria
        }
        catch (Exception erro)
        {} // sei que não vai dar erro

        return retorno;
    }

    private boolean tabuleiroCheio ()
    {
        // verificar se todas as posicoes do
        // tabuleiro estao preenchidas (!=null)
        // retornando true em caso afirmativo,
        // ou false em caso negativo
        try
        {
            for (int lin=0; lin<3; lin++)
                for (int col=0; col<3; col++)
                    if (!this.tabDoJogo.haMarcaNaPosicao(lin,col)) return false;
        }
        catch (Exception erro)
        {} // sei que não vai dar erro

        return true;
    }

    public boolean fimDeJogo ()
    {
        // se getMarcaDoVencedor != null,
        // retorna true
        // se tabuleiroCheio == true,
        // retorna true
        // caso contrario, retorna false
        if (this.getMarcaDoVencedor()!=null) return true;
        if (this.tabuleiroCheio()) return true;

        return false;
    }

    @Override
    public String toString ()
    {
        // faça
        Marca vencedor = this.getMarcaDoVencedor();

        return "Tabuleiro:\n" + this.tabDoJogo + "\n" +
               "Situação.: " + (vencedor!=null ? "vitória de "+vencedor :
                                this.tabuleiroCheio() ? "deu velha" : "em andamento");
    }

    @Override
    public boolean equals (Object obj)
    {
        // retornar true se this for igual a obj ou false caso contrario
        if (obj==this) return true;
        if (obj==null) return false;

        if (obj.getClass()!=this.getClass()) return false;
        AnalistaSituacional ana = (AnalistaSituacional)obj;

        if (!this.tabDoJogo.equals(ana.tabDoJogo)) return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        // faça
        int retorno=1;

        retorno=retorno*2 + this.tabDoJogo.hashCode();

        if (retorno<0) retorno = -retorno;
        return retorno;
    }
}
