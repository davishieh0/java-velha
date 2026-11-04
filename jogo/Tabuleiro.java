package jogo;

public class Tabuleiro implements Cloneable
{
    // a principio, toda igual a null
    private Marca matriz [][];

    public Tabuleiro ()
    {
        this.matriz = new Marca [3][3];
    }

    private static boolean valida (int lin, int col)
    {
        if (lin<0 || lin>2) return false;
        if (col<0 || col>2) return false;

        return true;
    }

    public boolean haMarcaNaPosicao (int lin, int col) throws Exception
    {
        // verifico se em matriz[lin][col]
        // tem null, retornando false em caso
        // afirmativo, ou true em caso negativo
        // dar excecao caso lin ou col invalido
        if (!Tabuleiro.valida(lin,col)) throw new Exception ("Posição inválida");

        return this.matriz[lin][col]!=null;
    }

    public Marca getMarcaNaPosicao (int lin, int col) throws Exception
    {
        // retornar a marca que tem em
        // matriz[lin][col]
        // dar excecao caso lin ou col invalido
        if (!Tabuleiro.valida(lin,col)) throw new Exception ("Posição inválida");

        return this.matriz[lin][col]; // Marca é imutável, não precisa de clone
    }

    public void setMarcaNaPosicao (Marca mrc, int lin, int col) throws Exception
    {
        // colocar mrc em matriz[lin][col],
        // dar excecao caso lin ou col invalido
        // dar excecao caso mrc seja null
        if (mrc==null) throw new Exception ("Marca ausente");
        if (!Tabuleiro.valida(lin,col)) throw new Exception ("Posição inválida");
        if (this.matriz[lin][col]!=null) throw new Exception ("Posição ocupada");

        this.matriz[lin][col]=mrc; // Marca é imutável, não precisa de clone
    }

    @Override
    public String toString ()
    {
        // retornar em um String o tabuleiro
        // formatado para ser exibido na tela
        String retorno="    0   1   2\n";

        for (int lin=0; lin<3; lin++)
        {
            retorno+=lin+" ";

            for (int col=0; col<3; col++)
            {
                retorno+=" "+(this.matriz[lin][col]==null?" ":this.matriz[lin][col].toString())+" ";
                if (col<2) retorno+="|";
            }

            if (lin<2) retorno+="\n  ---+---+---\n";
        }

        return retorno;
    }

    @Override
    public boolean equals (Object obj)
    {
        // retornar true se this for igual a obj ou false caso contrario
        if (obj==this) return true;
        if (obj==null) return false;

        if (obj.getClass()!=this.getClass()) return false;
        Tabuleiro tab = (Tabuleiro)obj;

        for (int lin=0; lin<3; lin++)
            for (int col=0; col<3; col++)
            {
                if (this.matriz[lin][col]==null)
                {
                    if (tab.matriz[lin][col]!=null) return false;
                }
                else
                    if (!this.matriz[lin][col].equals(tab.matriz[lin][col])) return false;
            }

        return true;
    }

    @Override
    public int hashCode ()
    {
        // faça
        int retorno=1;

        for (int lin=0; lin<3; lin++)
            for (int col=0; col<3; col++)
            {
                retorno=retorno*13;
                if (this.matriz[lin][col]!=null)
                    retorno=retorno + this.matriz[lin][col].hashCode();
            }

        if (retorno<0) retorno = -retorno;
        return retorno;
    }

    // construtor de copia
    public Tabuleiro (Tabuleiro modelo) throws Exception
    {
        // faça
        if (modelo==null) throw new Exception ("Modelo ausente");

        this.matriz=new Marca [3][3]; // A T E N Ç Ã O: matriz nova, pois setMarcaNaPosicao altera a matriz por dentro

        for (int lin=0; lin<3; lin++)
            for (int col=0; col<3; col++)
                this.matriz[lin][col]=modelo.matriz[lin][col]; // Marca é imutável, shallow copy basta
    }

    @Override
    public Object clone ()
    {
        // faça
        Tabuleiro retorno=null;

        try
        {
            retorno = new Tabuleiro (this);
        }
        catch (Exception erro)
        {} // sei que não vai dar erro

        return retorno;
    }
}
