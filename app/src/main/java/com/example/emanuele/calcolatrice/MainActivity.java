package com.example.emanuele.calcolatrice;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Vector;


public class MainActivity extends ActionBarActivity {

    private EditText editText;

    private Button numpad0;
    private Button numpad1;
    private Button numpad2;
    private Button numpad3;
    private Button numpad4;
    private Button numpad5;
    private Button numpad6;
    private Button numpad7;
    private Button numpad8;
    private Button numpad9;

    private Button operatorMul;
    private Button operatorDiv;
    private Button operatorSum;
    private Button operatorDiff;
    private Button operatorAns;

    private Button operatorClear;
    private Button operatorClearAll;

    private View.OnClickListener numpad0Listener;
    private View.OnClickListener numpad1Listener;
    private View.OnClickListener numpad2Listener;
    private View.OnClickListener numpad3Listener;
    private View.OnClickListener numpad4Listener;
    private View.OnClickListener numpad5Listener;
    private View.OnClickListener numpad6Listener;
    private View.OnClickListener numpad7Listener;
    private View.OnClickListener numpad8Listener;
    private View.OnClickListener numpad9Listener;

    private View.OnClickListener MulListener;
    private View.OnClickListener DivListener;
    private View.OnClickListener SumListener;
    private View.OnClickListener DiffListener;
    private View.OnClickListener AnsListener;

    private View.OnClickListener CListener;
    private View.OnClickListener CEListener;

    private Vector<Integer> numbers = new Vector<Integer>();

    private String[] operators = {"+", "-", "÷", "×"};
    private String[] numberRemoving = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    private int isLast = 0, buffer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);

        numpad0 = (Button)findViewById(R.id.button00);
        numpad1 = (Button)findViewById(R.id.button01);
        numpad2 = (Button)findViewById(R.id.button02);
        numpad3 = (Button)findViewById(R.id.button03);
        numpad4 = (Button)findViewById(R.id.button04);
        numpad5 = (Button)findViewById(R.id.button05);
        numpad6 = (Button)findViewById(R.id.button06);
        numpad7 = (Button)findViewById(R.id.button07);
        numpad8 = (Button)findViewById(R.id.button08);
        numpad9 = (Button)findViewById(R.id.button09);

        operatorAns = (Button)findViewById(R.id.buttonAns);
        operatorMul = (Button)findViewById(R.id.buttonMul);
        operatorDiv = (Button)findViewById(R.id.buttonDiv);
        operatorSum = (Button)findViewById(R.id.buttonSum);
        operatorDiff = (Button)findViewById(R.id.buttonDiff);

        operatorClear = (Button)findViewById(R.id.buttonCE);
        operatorClearAll = (Button)findViewById(R.id.buttonC);

        numpad0Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "0");
            }
        };

        numpad1Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "1");
            }
        };

        numpad2Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "2");
            }
        };

        numpad3Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "3");
            }
        };

        numpad4Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "4");
            }
        };

        numpad5Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "5");
            }
        };

        numpad6Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "6");
            }
        };

        numpad7Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "7");
            }
        };

        numpad8Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "8");
            }
        };

        numpad9Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "9");
            }
        };

        CListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                numbers.removeAllElements();
                isLast = 0;
                buffer = 0;
            }
        };

        CEListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < 4; i++)
                {
                    if(editText.getText().toString().substring(editText.getText().toString().length() - 1).equals(operators[i]))//se quello che sto cancellando è un operatore allora
                                                                                                                                //devo anche cancellare l'ultimo numero che ho aggiunto
                    {                                                                                                           //per non contarlo due volte
                        numbers.remove(numbers.lastIndexOf(numbers.lastElement()));
                    }

                }

                String text = editText.getText().toString();
                if(text.length() == 0) return;
                text = text.substring(0, text.length() - 1);
                editText.setText(text);
            }
        };

        MulListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLast = 0;
                for(int i = 0; i < 4; i++) //controllo se nell'editText ci sono già degli operatori
                {
                    buffer = editText.getText().toString().lastIndexOf(operators[i]); //ritorna un -1 se non c'è quel simbolo
                    if(buffer > isLast)
                    {
                        isLast = buffer;
                    }
                }

                if (isLast == 0) { //se non c'è nessun operatore nell'editText vuol dire che c'è un solo numero nell'editText, lo aggiungo alla lista
                    numbers.add(Integer.parseInt(editText.getText().toString()));
                    editText.setText(editText.getText() + "×");
                }
                else {
                    numbers.add(Integer.parseInt(editText.getText().toString().substring(isLast + 1))); //sennò aggiungo il numero che si trova dopo l'ultimo operatore
                    editText.setText(editText.getText() + "×");
                }
            }
        };

        DivListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLast = 0;
                for(int i = 0; i < 4; i++)
                {
                    buffer = editText.getText().toString().lastIndexOf(operators[i]);
                    if(buffer > isLast)
                    {
                        isLast = buffer;
                    }
                }

                if (isLast == 0) {
                    numbers.add(Integer.parseInt(editText.getText().toString()));
                    editText.setText(editText.getText() + "÷");
                }
                else {
                    numbers.add(Integer.parseInt(editText.getText().toString().substring(isLast + 1)));
                    editText.setText(editText.getText() + "÷");
                }
            }
        };

        SumListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLast = 0;
                for(int i = 0; i < 4; i++)
                {
                    buffer = editText.getText().toString().lastIndexOf(operators[i]);
                    if(buffer > isLast)
                    {
                        isLast = buffer;
                    }
                }

                if (isLast == 0) {
                    numbers.add(Integer.parseInt(editText.getText().toString()));
                    editText.setText(editText.getText() + "+");
                }
                else {
                    numbers.add(Integer.parseInt(editText.getText().toString().substring(isLast + 1)));
                    editText.setText(editText.getText() + "+");
                }
            }
        };

        DiffListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLast = 0;
                for(int i = 0; i < 4; i++)
                {
                    buffer = editText.getText().toString().lastIndexOf(operators[i]);
                    if(buffer > isLast)
                    {
                        isLast = buffer;
                    }
                }

                if (isLast == 0) {
                    numbers.add(Integer.parseInt(editText.getText().toString()));
                    editText.setText(editText.getText() + "-");
                }
                else {
                    numbers.add(Integer.parseInt(editText.getText().toString().substring(isLast + 1)));
                    editText.setText(editText.getText() + "-");
                }
            }
        };


        AnsListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLast = 0;
                for(int i = 0; i < 4; i++)
                {
                    buffer = editText.getText().toString().lastIndexOf(operators[i]);
                    if(buffer > isLast)
                    {
                        isLast = buffer;
                    }
                }
                numbers.add(Integer.parseInt(editText.getText().toString().substring(isLast + 1))); //Aggiungo l'ultimo numero

                String onlyOperators = editText.getText().toString();
                for(int i = 0; i < numberRemoving.length; i++) { //Rimuovo i numeri dalla stringa
                    onlyOperators = onlyOperators.replaceAll(numberRemoving[i], "");
                }

                int i = 0, ans = 0;

                while(onlyOperators.length() != 0) //Finché non ho cancellato tutti gli operatori
                {
                    if (i == 0) { //Se è la prima operazione devo usare i primi due numeri
                        switch (onlyOperators.charAt(0)) {
                            case '+':
                                ans = (numbers.get(i) + numbers.get(i+1));
                                onlyOperators = onlyOperators.substring(1);
                                break;

                            case '-':
                                ans = (numbers.get(i) - numbers.get(i+1));
                                onlyOperators = onlyOperators.substring(1);
                                break;

                            case '×':
                                ans = (numbers.get(i) * numbers.get(i+1));
                                onlyOperators = onlyOperators.substring(1);
                                break;

                            case '÷':
                                ans = (numbers.get(i) / numbers.get(i+1));
                                onlyOperators = onlyOperators.substring(1);
                                break;
                        }
                    }
                    else{ //Sennò posso usare il risultato come uno dei termini
                        switch (onlyOperators.charAt(0)) {
                            case '+':
                                ans += (numbers.get(i+1));
                                onlyOperators = onlyOperators.substring(1);
                                break;

                            case '-':
                                ans -= (numbers.get(i+1));
                                onlyOperators = onlyOperators.substring(1);
                                break;

                            case '×':
                                ans *= (numbers.get(i+1));
                                onlyOperators = onlyOperators.substring(1);
                                break;

                            case '÷':
                                ans /= (numbers.get(i+1));
                                onlyOperators = onlyOperators.substring(1);
                                break; //non necessario
                        }
                    }
                    i++;
                }

                String display = String.valueOf(ans);
                editText.setText(display);
            }
            };
        /*AnsListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                *//*FUNZIONAMENTO:
                PARSE è una lista di EntryItem.
                EntryItem è una clase che contiene gli attributi value (String) e type (bool)
                    type = true => indica che quell'oggeto contiene un operatore
                    type = false => indica che quell'oggetto contiene un numero
                Analizzo carater per carattere tutta la stringa contenuta nell'editText e man mano che trovo
                un numero oppure un operatore lo aggiungo alla lista PARSE.

                In un secondo momento itero attraverso tutti gli elementi della lista PARSE effetuando le operazioni
                che ci sono scritte
                *//*

                Vector<EntryItem> parse = new Vector<EntryItem>();
                int i=0;

                String text = editText.getText().toString();
                if(!isNumber(text.charAt(0))) return;


                String lastValue = "";
                boolean lastType = false; //false = number, true = operator
                EntryItem current = new EntryItem();

                while(true)
                {
                    if(i==text.length()-1) { //ho finito di analizzare la stringa
                        if(!lastType) //stavo leggendo un numero
                        {
                            current.value = lastValue;
                            current.type = false;
                            parse.addElement(current);
                        }
                        //il caso in cui nel ciclo precedente ho letto un operatore non mi interessa perché ignoro operatori a fine stringa
                        else {
                            current.value = lastValue;
                            current.type = true;
                            parse.addElement(current);
                        }
                        break;
                    }

                    if(isNumber(text.charAt(i))) { //se il carattere che sto analizzando è un numero
                        if(lastType) //Il carattere che ho in memoria è un operatore
                        { //salvo l'operatore nella lista di oggetti parse
                            current.value = lastValue;
                            current.type = true;
                            parse.addElement(current);
                            current = new EntryItem();
                            lastValue = "";
                        }
                        lastType = false; //il prossimo ciclo sa che il carattere analizzato in precedenza era un numero
                        lastValue += text.charAt(i); //appendo la cifra a lastValue
                    }
                    else {
                        if(!lastType) //Ho rovato un carattere che è un operatore ma stavo leggendo un numero
                        {
                            current.value = lastValue;
                            current.type = false;
                            parse.addElement(current);
                            current = new EntryItem();
                            lastValue = "";
                        }
                        lastType = true;
                        lastValue += text.charAt(i);
                    }
                    i++;
                }

            }
        };*/

        numpad0.setOnClickListener(numpad0Listener);
        numpad1.setOnClickListener(numpad1Listener);
        numpad2.setOnClickListener(numpad2Listener);
        numpad3.setOnClickListener(numpad3Listener);
        numpad4.setOnClickListener(numpad4Listener);
        numpad5.setOnClickListener(numpad5Listener);
        numpad6.setOnClickListener(numpad6Listener);
        numpad7.setOnClickListener(numpad7Listener);
        numpad8.setOnClickListener(numpad8Listener);
        numpad9.setOnClickListener(numpad9Listener);

        operatorMul.setOnClickListener(MulListener);
        operatorDiv.setOnClickListener(DivListener);
        operatorSum.setOnClickListener(SumListener);
        operatorDiff.setOnClickListener(DiffListener);

        operatorClear.setOnClickListener(CEListener);
        operatorClearAll.setOnClickListener(CListener);

        operatorAns.setOnClickListener(AnsListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    boolean isNumber(char n) {
        return(n=='0' || n=='1' || n=='2' || n=='3' || n=='4' || n=='5' || n=='6'||n=='7'||n=='8'||n=='9');
    }
}
