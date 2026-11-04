package jogador;

import utils.Teclado;
import jogo.Marca;
import jogo.Tabuleiro;
import java.io.*;

public class JogadorHumano implements Jogador, Cloneable
{
    private Marca          marca     = null;
    private Tabuleiro      tabDoJogo = null;
    private BufferedReader teclado   = new BufferedReader
                                        (new InputStreamReader
                                        (System.in));

    public JogadorHumano (Tabuleiro tab) throws Exception
    {
        // atribuir tab para tabDoJogo
        // pedir para o jogador escolher
        // sua marca e permitir digitacao
        // intanciando marca
        if (tab==null) throw new Exception ("Tabuleiro ausente");

        this.tabDoJogo = tab;

        do
        {
            try
            {
                System.out.print ("Escolha sua marca (X ou O): ");
                this.marca = new Marca(Teclado.getUmChar());
            }
            catch (Exception erro)
            {
                System.out.println (erro.getMessage());
            }
        }
        while (this.marca==null);

    }

    public JogadorHumano (Tabuleiro tab, Marca mrc) throws Exception
    {
        // atribuir tab para tabDoJogo
        // e mrc para marca
        if (tab==null) throw new Exception ("Tabuleiro ausente");
        if (mrc==null) throw new Exception ("Marca ausente");

        tabDoJogo = tab;
        marca = mrc;
    }

    public Marca getMarca ()
    {
        // retorna a marca do jogador
        return this.marca;
    }

    public void facaSuaJogada ()
    {
        // pergunta para o jogador onde ele quer
        // jogar, permitindo digitacao e chamando
        // os métodos apropriados de tabDoJogo

        System.out.println ();
        System.out.println (this.tabDoJogo);

        boolean jogou=false;

        do
        {
            System.out.println("Digite a linha e coluna do movimento:");

            try {
                int linha = Teclado.getUmInt();
                int coluna = Teclado.getUmInt();
                tabDoJogo.setMarcaNaPosicao(marca, linha, coluna);
                jogou=true;
            }
            catch(Exception erro){
                System.out.println("Erro ao realizar jogada: " + erro.getMessage());
            }
        }
        while (!jogou);

    }

    public void vcGanhou ()
    {
        // mostra mensagem indicando vitoria
        System.out.println ();
        System.out.println (this.tabDoJogo);
        System.out.println ("Você ganhou!");
    }

    public void vcPerdeu ()
    {
        // mostra mensagem indicando derrota
        System.out.println ();
        System.out.println (this.tabDoJogo);
        System.out.println ("Você perdeu!");
    }

    public void deuVelha ()
    {
        // mostra mensagem indicando empate
        System.out.println ();
        System.out.println (this.tabDoJogo);
        System.out.println ("Deu velha!");
    }

    public boolean querMaisUmaPartida ()
    {
        // perguntar se deseja jogar de novo
        // permitindo digitacao e retornando
        // true ou false, conforme a resposta
        char resposta=' ';

        do
        {
            try
            {
                System.out.print ("Quer jogar mais uma partida (S/N)? ");
                resposta=Character.toUpperCase(Teclado.getUmChar());
            }
            catch (Exception erro)
            {
                System.out.println (erro.getMessage());
            }
        }
        while (resposta!='S' && resposta!='N');

        return resposta=='S';
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
        JogadorHumano jog = (JogadorHumano)obj;

        if (!this.marca.equals(jog.marca)) return false;
        if (!this.tabDoJogo.equals(jog.tabDoJogo)) return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        int retorno=1;

        retorno = retorno * 2 + this.marca.hashCode();
        retorno = retorno * 2 + this.tabDoJogo.hashCode();
      //retorno = retorno * 2 + ((Byte)this.segundo).hashCode();


        if (retorno<0) retorno=-retorno;
        return retorno;
    }

    // construtor de cópia
    public JogadorHumano (JogadorHumano modelo) throws Exception

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
        JogadorHumano retorno=null;

        try
        {
            retorno = new JogadorHumano (this);
        }
        catch (Exception erro)
        {} // sei que não vai dar erro

        return retorno;
    }
}
