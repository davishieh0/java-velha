package jogador;

import jogo.Marca;
import jogo.Tabuleiro;

public class JogadorAutomatico implements Jogador, Cloneable
{
    private Marca     marca     = null;
    private Tabuleiro tabDoJogo = null;

    public JogadorAutomatico (Tabuleiro tab) throws Exception
    {
        // atribuir tab para tabDoJogo
        // fazer o jogador escolher sua marca
        // via sorteio de numeros aleatorio
        if (tab==null) throw new Exception ("Tabuleiro ausente");

        this.tabDoJogo=tab; // sem clone: tem que ser o mesmo tabuleiro do jogo

        if ((int)(Math.random()*2) == 0)
            this.marca=new Marca ('X');
        else
            this.marca=new Marca ('O');
    }

    public JogadorAutomatico (Tabuleiro tab, Marca mrc) throws Exception
    {
        // atribuir tab para tabDoJogo
        // e mrc para marca
        if (tab==null) throw new Exception ("Tabuleiro ausente");
        if (mrc==null) throw new Exception ("Marca ausente");

        this.tabDoJogo=tab; // sem clone: tem que ser o mesmo tabuleiro do jogo
        this.marca=mrc;
    }

    public Marca getMarca ()
    {
        // retorna a marca do jogador
        return this.marca;
    }

    public void facaSuaJogada ()
    {
        try
        {
            // tentando ganhar na linha 0
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(0,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(0,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            // tentando ganhar na linha 1
            if (!this.tabDoJogo.haMarcaNaPosicao(1,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
            else
            // tentando ganhar na linha 2
            if (!this.tabDoJogo.haMarcaNaPosicao(2,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
            else
            // tentando ganhar na coluna 0
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,0))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
            else
            // tentando ganhar na coluna 1
            if (!this.tabDoJogo.haMarcaNaPosicao(0,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,1))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);
            else
            // tentando ganhar na coluna 2
            if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,2) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
            else
            // tentando ganhar na diagonal principal
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
            else
            // tentando ganhar na diagonal secundaria
            if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,0))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
            else
            // tentando atrapalhar vitoria na linha 0
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(0,1) && !this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(0,2) && !this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,0) && !this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(0,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(0,2) && !this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,0) && !this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(0,1) && !this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(0,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            // tentando atrapalhar vitoria na linha 1
            if (!this.tabDoJogo.haMarcaNaPosicao(1,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && !this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,2) && !this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(1,0) && !this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,2) && !this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(1,0) && !this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && !this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
            else
            // tentando atrapalhar vitoria na linha 2
            if (!this.tabDoJogo.haMarcaNaPosicao(2,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,1) && !this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,2) && !this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(2,0) && !this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,2) && !this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(2,0) && !this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,1) && !this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
            else
            // tentando atrapalhar vitoria na coluna 0
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,0) && !this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,0) && !this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,0) && !this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,0) && !this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,0) && !this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,0) && !this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,0))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
            else
            // tentando atrapalhar vitoria na coluna 1
            if (!this.tabDoJogo.haMarcaNaPosicao(0,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && !this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,1) && !this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,1) && !this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,1) && !this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,1) && !this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && !this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,1))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);
            else
            // tentando atrapalhar vitoria na coluna 2
            if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,2) && !this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,2) && !this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,2) && !this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,2) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,2) && !this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,2) && !this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,2) && !this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
            else
            // tentando atrapalhar vitoria na diagonal principal
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && !this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,2) && !this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,0) && !this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,2) && !this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,0) && !this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && !this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
            else
            // tentando atrapalhar vitoria na diagonal secundaria
            if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && !this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,0) && !this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,2) && !this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,0) && !this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
            else
            if ( this.tabDoJogo.haMarcaNaPosicao(0,2) && !this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && !this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,0))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
            else
            // tentando jogada de futuro (há 1 marca do jogador e mais nada; vamos lá e plantamos outra marca) na linha 0
            if ( this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(0,1) &&
                !this.tabDoJogo.haMarcaNaPosicao(0,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(0,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                !this.tabDoJogo.haMarcaNaPosicao(0,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            // tentando jogada de futuro (há 1 marca do jogador e mais nada; vamos lá e plantamos outra marca) na linha 1
            if ( this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(1,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(1,0) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
            else
            // tentando jogada de futuro (há 1 marca do jogador e mais nada; vamos lá e plantamos outra marca) na linha 2
            if ( this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,1) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(2,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(2,0) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
            else
            // tentando jogada de futuro (há 1 marca do jogador e mais nada; vamos lá e plantamos outra marca) na coluna 0
            if ( this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,0) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,0))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,0))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            // tentando jogada de futuro (há 1 marca do jogador e mais nada; vamos lá e plantamos outra marca) na coluna 1
            if ( this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,1))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,1))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,1) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
            else
            // tentando jogada de futuro (há 1 marca do jogador e mais nada; vamos lá e plantamos outra marca) na coluna 2
            if ( this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,2) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,2) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            // tentando jogada de futuro (há 1 marca do jogador e mais nada; vamos lá e plantamos outra marca) na diagonal principal
            if ( this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,2))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            // tentando jogada de futuro (há 1 marca do jogador e mais nada; vamos lá e plantamos outra marca) na diagonal secundaria
            if ( this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,0))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                 this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
                !this.tabDoJogo.haMarcaNaPosicao(2,0))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                 this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
                 this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            // termine jogando num lugar qualquer que esteja livre
            {
                int lin, col;

                do
                {
                    lin=(int)(Math.random()*3);
                    col=(int)(Math.random()*3);
                }
                while (this.tabDoJogo.haMarcaNaPosicao(lin,col));

                this.tabDoJogo.setMarcaNaPosicao(this.marca, lin,col);
            }
        }
        catch (Exception erro)
        {} // ignorando pois sei que não estou usando posicao invalida nem comparando com equals um null
    }

    @Override
    public String toString ()
    {
        // faça
        return "Marca....: " + this.marca + "\n" +
               "Tabuleiro:\n" + this.tabDoJogo;
    }

    @Override
    public boolean equals (Object obj)
    {
        // faça
        if (obj==this) return true;
        if (obj==null) return false;

        if (obj.getClass()!=this.getClass()) return false;
        JogadorAutomatico jog = (JogadorAutomatico)obj;

        if (!this.marca.equals(jog.marca)) return false;
        if (!this.tabDoJogo.equals(jog.tabDoJogo)) return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        // faça
        int retorno=1;

        retorno=retorno*2 + this.marca.hashCode();
        retorno=retorno*2 + this.tabDoJogo.hashCode();

        if (retorno<0) retorno = -retorno;
        return retorno;
    }

    // construtor de cópia
    public JogadorAutomatico (JogadorAutomatico modelo) throws Exception
    {
        // faça
        if (modelo==null) throw new Exception ("Modelo ausente");

        this.marca    =modelo.marca;
        this.tabDoJogo=(Tabuleiro)modelo.tabDoJogo.clone(); // A T E N Ç Ã O: deep copy, pois facaSuaJogada altera o tabuleiro
    }

    @Override
    public Object clone ()
    {
        // faça
        JogadorAutomatico retorno=null;

        try
        {
            retorno = new JogadorAutomatico (this);
        }
        catch (Exception erro)
        {} // sei que não vai dar erro

        return retorno;
    }
}
