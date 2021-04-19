package com.company;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.String;
import java.util.Scanner;
import java.io.IOException;

enum States
{
    State_Start,
    State_Number,
    State_Word,
    State_Skip
};

public class ReadFile {


    String[] words;
    //int size = 0;
    int connects_num =0;
    char w0;
    ArrayList<String> FinalWords = new ArrayList<String>();


    void read() throws IOException {

        System.out.println("Введите данные в консоль: ");
        w0 = (char) System.in.read();

        File file = new File("file.txt");
        Scanner scan = new Scanner(file);

        String fileContent = "";

        while (scan.hasNextLine()) {
            fileContent = fileContent.concat(scan.nextLine() + "\n");

        }
        words = fileContent.split("[={}()+-/#*—“”\"\'\\s.,;:!&?$’‘\\[\\]\\\\]+");

        System.out.println(Arrays.toString(words));
    }

   /* void foo() {
        HashSet<String> uniqueWords = new HashSet<String>(Arrays.asList(words));
        int Vowel;
        double wordsize=0.0;
        size = uniqueWords.size();
        char[] VowelSounds={'A','E','I','O','U','Y','a','e','i','o','u','y'};
        String word;
        char[] bukvy;
        int length;
        for (int i = 0; i <= size; ++i)
        {
                word = words[i];
                //System.out.println("word =" + word);
                bukvy = word.toCharArray();
                Vowel=0;
                length=word.length();
                for (int x = 0; x < bukvy.length; ++x)
                {
                    for(int y=0;y<VowelSounds.length;++y)
                    {
                        if(bukvy[x]==VowelSounds[y])
                        {
                            ++Vowel;
                        }

                    }

                }

                wordsize= length*0.5;
                String print;
                int l;
                if(Vowel> wordsize)
                {

                    l=0;
                    if(FinalWords.size()>0)
                    {
                        for(int k =0; k < FinalWords.size();++k)
                        {
                            print =  FinalWords.get(k);
                            if(print.equals(word))
                            {

                                l=1;
                            }
                        }
                    }

                    if(l==0 && length<=30)
                    {
                        FinalWords.add(word);

                    }

                }
        }

        String print;
        for(int i =0; i < FinalWords.size();++i)
        {
            print=  FinalWords.get(i);
            System.out.println(i + " - "+ print);
        }





    }*/

    void data_processing()  {
        int i = 0;
       /* char abc[]=
                {
                       //0   1   2   3   4   5   6  7    8   9   10  11  12
                        'a','b','c','d','e','f','g','h','i','j','k','l','m',
                        'n','o','p','q','r','s','t','u','v','w','x','y','z',

                        'A','B','C','D','E','F','G','H','I','J','K','L','M',
                        'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
                };
        int abc_num[]= { 0,1,2,3,4,5,6,7,8,9,10,11,12,14,15,16,17,18,19,20,21,22,23,24,25,26,
                         27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51};
        for(;i<= abc.length;++i)
        {
        System.out.print(abc[i]+" -> "+ abc_num[i]+'\n');
        }*/

        // firs 1 : abcArr[0]= nothing
        char[] abcArr = words[0].toCharArray();
        char[] state_char = words[1].toCharArray();
        int size_abc = abcArr.length, size_state = state_char.length;

        int[] state_arr = new int[size_state];

        /*for(;i<size_abc;++i)
        {
            System.out.print(i+"->"+abcArr[i]+'\n');
        } *///Print abcArr

        while (i < size_state) {
            state_arr[i] = Character.getNumericValue(state_char[i]);
            ++i;
        }
       /* i=0;
        while(i<state_arr.length)
        {
            System.out.print(state_arr[i]);
            ++i;
        }*/ //Print state_arr

        int Start_state = Character.getNumericValue(words[2].charAt(0));
        int finish = Character.getNumericValue(words[3].charAt(0));
        int size_words = words.length;
        // connects_num= size_words-3;
        connects_num = state_arr.length;
        // Connecting with letter in  (1 h 2)
        int with[] = new int[connects_num];
        char connect[] = new char[connects_num];
        int in[] = new int[connects_num];


        i = 0;
        int j = 0, l = 4;
        while (i < connects_num) {
            char line_connect[] = words[l].toCharArray();
            with[j] = Character.getNumericValue(line_connect[0]);
            connect[j] = line_connect[1];
            in[j] = Character.getNumericValue(line_connect[2]);

            ++i;
            ++j;
            ++l;
        }




        /*for(;i<connects_num;++i)
        {//Start_state
            for (;j<with.length;++j)
            {

                if(with[j]==state)
                {
                    index =j;
                }
            }
            j=0;
            for(;j<size_abc;++j)
            {
                if(connect[index]== abcArr[j])
                {
                    state = in[index];
                }
                else
                    state = Start_state;
            }
        } //for
        int n=0;
        int w = state,In;

      /* for(i=0;i<connects_num;++i)
       {


           if(with[i]==w)
           {

               for (j=0;j<size_abc;++j)
               {
                   if(connect[i]==abcArr[j])
                   {
                    w=in[i];
                    i=0;
                    if(4==)
                    break;
                   }
               }


           }
           continue;
       }*/


        int state = Start_state;
        int etap=0;
        int pos=0;
        while(etap!=10)
        {
            switch (etap) {
                case 0: //first

                    for (j = 0; j < with.length; ++j) {

                        if (with[j] == state) {
                            pos=in[j];
                            etap=1;
                            break;
                        }

                    }

                    break;
                case 1:

                    if(connect[j+1]==w0)
                    {
                        pos=in[pos];
                        ++pos;
                        etap=2;
                    }
                    else
                    {
                        etap= 4;
                    }



                    break;
                case 2: //first

                        if(pos==finish)
                        {
                            etap=3;
                        }
                        else
                        {
                            etap=4;
                        }

                    break;

                case 3:

                    System.out.println("Автомата допускає слова вигляду w1w0w2 \n Де w0 = " + w0);
                    etap=10;

                    break;
                case 4:
                    System.out.println("Автомата не допускає слова вигляду w1w0w2 \n Де w0 = " + w0);
                    etap=10;

                    break;

        }


        }


        //int finish =4;




      /*  for(i=0;stop != 1;++i)
        {
            switch (etap)
            {
                case 0: //first

                    for(j=0;j<with.length;++j)
                        {

                            if(with[j]==state )
                            {
                                etap=1;
                                break;
                            }

                        }

                    break;


                case  1:
                        for(;l<size_abc;++l)
                        {
                            if(size_abc==l)
                            {
                                stop =1;
                            }
                            if(connect[j]==abcArr[l] )
                            {
                                if(state==finish)
                                {
                                    ++word;
                                    etap = 0;
                                    state= Start_state;
                                    break;

                                }
                                else
                                {
                                    state=in[j];
                                    ++l;
                                    etap = 0;
                                    break;
                                }

                            }
                        }
                        if(l>=size_abc)
                        {
                            stop =1;
                        }

                    break;
                case 2:
                        for(int n=0;n<(size_abc-l);++n)
                        {
                           for(s=0;s< size_words;++s)
                            {
                                if(with[s]==state)
                                {
                                    break;
                                }

                            }
                            for(s=0;s< with.length;++s)
                                {
                                    if(with[s]==state)
                                    {
                                        break;
                                    }

                                }

                            if(connect[s]==abcArr[l])
                            {
                                state=in[s];

                                ++l;
                                if(state == finish)
                                {
                                    ++word;
                                    etap = 0;
                                    state= Start_state;
                                    break;

                                }


                            }
                            else
                            {
                                state= Start_state;
                                etap =0;
                                break;
                            }
                        }
                    break;

            }

        }


        System.out.println("word = "+ word);*/
    }








}

