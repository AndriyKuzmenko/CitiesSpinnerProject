package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener
{
    String[] continents={"-Continent-","Africa","Asia","Europe","N. America", "Oceania","S. America"}; //N.=North    S.=South

    String[][] countries={{"-Country-","Angola","Benin","Congo","Egypt","Ethiopia","Reunion","Senegal","S. Africa"},
                          {"-Country-","India","Israel","Japan","Nepal","Philippines","Sri Lanka","S. Korea","Taiwan"},
                          {"-Country-","Albania","Belgium","Finland","France","Germany","Norway","Spain","United Kingdom"},
                          {"-Country-","Trinidad and Tobago","El Salvador","Belize","Canada","Panama","Mexico","Honduras","United States"},
                          {"-Country-","Australia","Fiji","French Polynesia","Guam","New Caledonia","New Zealand","Niue","Samoa"},
                          {"-Country-","Argentina","Bolivia","Brazil","Chile","Falkland Islands","French Guiana","Peru","Uruguay"}};

    //Africa

    String[][] citiesAfrica={{"Luanda","N'dalatando","Lobito","Lubango","New Lisbon"},
                             {"Cotonou","Porto Novo","Parakou","Djougou","Bohican"},
                             {"Kinshasa","Lubumbashi","Kananga","Kolwezi","Mbuji-Mayi"},
                             {"Cairo","Alexandria","Luxor","El Mahmoudiyah","Giza"},
                             {"Addis Ababa","Dire Dawa","Bahir Dar","Hawassa","Dessie"},
                             {"Le Port","Le Tampon","St. Joseph","La Possession","Sainte-Marie"},
                             {"Dakar","Ziguinchor","Kaolack","Saint Louis","Tambaccounada"},
                             {"Cape Town","Johannesburg","Durban","Pretoria","Port Elizabeth"}};

    String[][] populationsAfrica={{"2,401,067","168,832","393,079","776,246","713,134"},
                                  {"231,626","264,320","206,667","237,040","149,271"},
                                  {"14,340,000","1,794,000","1,272,000","572,942","3,368,000"},
                                  {"9,908,788","5,200,000","506,588","24,300","8,800,000"},
                                  {"4,800,000","440,000","750,991","315,267","610,431"},
                                  {"34,128","78,629","37,644","33,020","32,940"},
                                  {"11,146,053","205,294","233,708","176,000","78,800"},
                                  {"3,740,026","5,635,127","3,720,953","2,472,612","967,677"}};

    String[][] areasAfrica={{"116 km^2","110 km^2","989 km^2","3,147 km^2","2,711 km^2"},
                            {"79 km^2","110 km^2","441 km^2","3,966 km^2","44 km^2"},
                            {"9,965 km^2","210 km^2","742.8 km^2","213 km^2","135.1 km^2"},
                            {"3,085.12 km^2","2,679 km^2","416 km^2","1,230","1,579.75 km^2"},
                            {"225.7 km^2","1,213 km^2","28 km^2","50 km^2","15.08 km^2"},
                            {"16.62 km^2","165.4 km^2","178.5 km^2","118.35 km^2","87.21 km^2"},
                            {"83 km^2","9 km^2","5,357 km^2","19,241 km^2","42,364 km^2"},
                            {"2,461 km^2","1,644.98 km^2","225.91 km^2","687.54 km^2","251.03 km^2"}};

    //Asia

    String[][] citiesAsia={{"Bombay","Bengaluru","Chennai","Kolkata","Hyderabad"},
                           {"Jerusalem","Tel Aviv","Haifa","Netnanya","Be'er Sheva"},
                           {"Tokyo","Osaka","Kyoto","Sapporo","Nagoya"},
                           {"Kathmandu","Pokhara","Lalitpur","Bhaktapur","Biratnagar"},
                           {"Manila","Quezon","Cebu City","Makati","Baguio"},
                           {"Colombo","Galle","Kandy","Jaffna","Trincomalee"},
                           {"Seoul","Busan","Incheon","Daegu","Ulsan"},
                           {"Taipei","Kaohsiung City","Tainan","Taichung","Keelung City"}};

    String[][] populationsAsia={{"18,410,000","8,426,000","7,088,000","14,850,000","6,810,000"},
                                {"874,186","435,856","279,249","209,390","204,707"},
                                {"9,273,000","2,691,000","1,475,000","1,952,000","2,296,000"},
                                {"1,003,000","264,991","226,728","81,728","204,949"},
                                {"1,780,000","2,936,000","922,611","582,602","345,366"},
                                {"752,993","93,118","125,400","88,138","99,135"},
                                {"9,776,053","3,429,000","2,923,400","2,465,000","1,166,000"},
                                {"2,646,000","2,773,000","1,881,000","2,817,000","371,878"}};

    String[][] areasAsia={{"603.4 km^2","709 km^2","463 km^2","206.1 km^2","625 km^2"},
                          {"125.1 km^2","52 km^2","63.67 km^2","28.5 km^2","117.5 km^2"},
                          {"2,194 km^2","223 km^2","827.8 km^2","1,121 km^2","326.4 km^2"},
                          {"3,085.12 km^2","464.2 km^2","37.4 km^2","16.89 km^2","58.48 km^2"},
                          {"42.88 km^2","166.2 km^2","28 km^2","50 km^2","57.5 km^2"},
                          {"37.31 km^2","16.52 km^2","28.53 km^2","20.2 km^2","7.5 km^2"},
                          {"605.2 km^2","770 km^2","1,063 km^2","883.5 km^2","1,057 km^2"},
                          {"271.8 km^2","2,952 km^2","2192 km^2","2,215 km^2","132.8 km^2"}};

    //Europe

    String[][] citiesEurope={{"Tirana","Berat","Durres","Gjirokaster","Vlore"},
                             {"Brussels","Bruges","Ghent","Antwerp","Leuven"},
                             {"Helsinki","Turku","Tampere","Oulu","Espoo"},
                             {"Paris","Marseilee","Strasborg","Bordeaux","Nice"},
                             {"Berlin","Munich","Humburg","Frankfurt","Cologne"},
                             {"Bergen","Oslo","Stavanger","Trondheim","Tromso"},
                             {"Madrid","Barcelona","Seville","Granada","Bilbao"},
                             {"London","Edinburgh","Oxford","Bristol","Manchester"}};

    String[][] populationsEurope={{"418,495","100,000","113,249","19,836","104,827"},
                                  {"174,383","117,260","248,358","498,473","100,224"},
                                  {"613,695","186,756","226,696","199,526","272,193"},
                                  {"2,161,000","861,635","277,270","249,712","342,522"},
                                  {"3,645,000","1,472,000","1,841,000","753,056","1,086,000"},
                                  {"271,949","634,293","130,754","182,035","71,590"},
                                  {"3,223,000","620,000","688,711","232,208","345,821"},
                                  {"8,982,000","482,005","152,450","467,099","553,230"}};

    String[][] areasEurope={{"41.8 km^2","6.3 km^2","338.3 km^2","5.25 km^2","647.9 km^2"},
                            {"32.61 km^2","138 km^2","156.2 km^2","204.5 km^2","56.63 km^2"},
                            {"213.8 km^2","243.4 km^2","523.4 km^2","1,410 km^2","312 km^2"},
                            {"105.4 km^2","240.6 km^2","78.26 km^2","49.36 km^2","71.92 km^2"},
                            {"891.8 km^2","310.4 km^2","755.2 km^2","248.3 km^2","405.2 km^2"},
                            {"445.4 km^2","454 km^2","71.35 km^2","321.8 km^2","2,521 km^2"},
                            {"604.3 km^2","101.9 km^2","688,711 km^2","88.02 km^2","41.6 km^2"},
                            {"1,572 km^2","264 km^2","45.59 km^2","110 km^2","115.6 km^2"}};

    //North America

    String[][] citiesNAmerica={{"Arima","Chaguanas Borough","Point Fortin","Sangre Grande","Penal"},
                               {"San Salvador","San Miguel","Sonsonate","Usulutan","Soyapango"},
                               {"Belize City","San Pedro","Belmopan","San Ignacio","Punta Gordon"},
                               {"Toronto","Vancouver","Montreal","Ottawa","Calgary"},
                               {"Panama City","Tocumen","David","Santiago","Chitre"},
                               {"Mexico City","Guadalajara","Ciudad Juarez","Tijuana","Merida"},
                               {"San Pedro Sula","La Ceiba","Comayagua","Atlantida","El Progreso"},
                               {"New York","San Francisco","Chicago","Washington D.C.","Los Angeles"}};

    String[][] populationsNAmerica={{"33,606","83,489","20,161","18,127","12,281"},
                                    {"238,244","265,921","72,951","73,064","283,223"},
                                    {"57,169","11,767","13,939","17,878","5,351"},
                                    {"2,930,000","675,218","1,780,270","994,837","1,336,000"},
                                    {"477,328","74,952","82,907","88,997","9,092"},
                                    {"8,855,000","1,495,000","1,321,000","1,301,000","776,615"},
                                    {"719,064","197,267","144,785","449,822","188,366"},
                                    {"8,399,000","883,305","2,706,000","684,498","3,990,0000"}};

    String[][] areasNAmerica={{"12 km^2","59 km^2","23.88 km^2","13.5 km^2","9.66 km^2"},
                              {"72.25 km^2","594 km^2","232.5 km^2","139.8 km^2","29.72 km^2"},
                              {"35.67 km^2","71.22 km^2","32.78 km^2","6 km^2","56.1 km^2"},
                              {"630.2 km^2","115 km^2","431.5 km^2","2,790 km^2","825.3 km^2"},
                              {"275 km^2","65.3 km^2","755.2 km^2","44.2 km^2","91 km^2"},
                              {"1,485 km^2","187.9 km^2","321.2 km^2","637 km^2","14,827 km^2"},
                              {"840 km^2","640 km^2","834 km^2","4,251 km^2","547.5 km^2"},
                              {"783.8 km^2","121.4 km^2","606.1 km^2","177 km^2","1,302 km^2"}};

    //Oceania

    String[][] citiesOceania={{"Sydeny","Melbourne","Perth","Adelaide","Brisbane"},
                              {"Suva","Nadi","Savusavu","Sigakota","Lautoka"},
                              {"Pape'eta","Arue","Mahina","Pa'ea","Fa'a'a"},
                              {"Hagatna","Agat","Dededo","Mangilao","Tamuning"},
                              {"Noumea","Mont-Dore","Dumbea","Tadline","Fayaoue"},
                              {"Auckland","Wellington","Christchurch","Dunedin","Nelson"},
                              {"Alofi","Avatele","Hakupu","Makefu","Mutalau"},
                              {"Apia","Asau","Afega","Vailima","Leulumoega"}};

    String[][] populationsOceania={{"5,230,000","4,936,000","1,985,000","1,306,000","2,280,000"},
                                   {"93,970","42,284","3,372","9,622","71,573"},
                                   {"25,763","10,243","14,764","13,021","29,506"},
                                   {"1,051","4,917","44,943","15,191","19,685"},
                                   {"94,285","27,620","35,873","7,492","4,411"},
                                   {"1,657,000","1,388","381,500","128,800","52,900"},
                                   {"639","143","220","70","100"},
                                   {"35,744","650","2,137","1,462","1,290"}};

    String[][] areasOceania={{"12,368 km^2","9,992 km^2","6,418 km^2","13.5 km^2","15,826 km^2"},
                             {"2,048 km^2","7.8 km^2","5,587.5 km^2","61 km^2","20 km^2"},
                             {"17.4 km^2","16 km^2","51.6 km^2","65 km^2","34.2 km^2"},
                             {"3.63 km^2","27.19 km^2","77.7 km^2","13.41 km^2","14.66 km^2"},
                             {"45.7 km^2","8.17 km^2","254.6 km^2","1.43 km^2","2.36 km^2"},
                             {"1,086 km^2","119.8 km^2","1,426 km^2","3,314 km^2","422.2 km^2"},
                             {"46.48 km^2","13.99 km^2","48.04 km^2","17.13 km^2","26.31 km^2"},
                             {"123.8 km^2","3.84 km^2","1 km^2","1 km^2","0.5 km^2"}};

    //South America

    String[][] citiesSAmerica={{"Buenos Aires","Cordoba","Mendoza","Ushuaia","Rosario"},
                               {"La Paz","Cochabamba","Sucre","Potosi","El Alto"},
                               {"Rio de Janeiro","Sao Paulo","Curitiba","Belo Horizonte","Porto Alegre"},
                               {"Santiago","Valparaiso","Vina del Mar","Punta Arenas","Concepcion"},
                               {"Port Stanley","Port Howard","Goose Greem","Hill Cove","North Arm"},
                               {"Cayene","St. Laurent de Maroni","Mana","Roura","Kourou"},
                               {"Lima","Cusco","Arequipa","Iquitos","Trujillo"},
                               {"Montevideo","Colonia del Sacramento","Punta del Este","Salto","Ciudad de la Costa"}};

    String[][] populationsSAmerica={{"2,890,000","325,708","1,886,000","56,500","1,700,000"},
                                    {"1,858,000","1,758,000","300,000","174,973","943,558"},
                                    {"6,320,000","12,180,000","1,765,000","1,433,000","1,409,000"},
                                    {"5,614,000","295,113","326,759","17,846","220,746"},
                                    {"2,108","20","40","16","25"},
                                    {"57,614","43,600","10,241","3,713","26,221"},
                                    {"8,575,000","428,450","1,008,000","447,000","682,834"},
                                    {"1,381,000","27,000","15,000","104,028","2,194"}};

    String[][] areasSAmerica={{"203 km^2","576 km^2","54 km^2","23 km^2","178.7 km^2"},
                              {"472 km^2","348 km^2","1,768.5 km^2","53 km^2","370 km^2"},
                              {"1,255 km^2","1,521 km^2","432 km^2","330.9 km^2","496.8 km^2"},
                              {"641 km^2","401.6 km^2","121.6 km^2","17,846 km^2","72 km^2"},
                              {"0.5 km^2","800 km^2","0.5 km^2","1 km^2","1 km^2"},
                              {"23.6 km^2","4,830 km^2","6,333 km^2","3,902 km^2","2,160 km^2"},
                              {"2,672 km^2","385.1 km^2","3,057 km^2","17.13 km^2","111.6 km^2"},
                              {"200 km^2","525.5 km^2","20.35 km^2","14,163 km^2","51.25 km^2"}};

    Spinner continentsSpinner, countriesSpinner;
    ListView citiesListView;
    TextView populationTextView, areaTextView;

    int continent, country;
    ArrayAdapter<String> adp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continentsSpinner=(Spinner)findViewById(R.id.continentSpinner);
        countriesSpinner=(Spinner)findViewById(R.id.countriesSpinner);
        citiesListView=(ListView)findViewById(R.id.citiesListView);
        populationTextView=(TextView)findViewById(R.id.populationTextView);
        areaTextView=(TextView)findViewById(R.id.areaTextView);

        continentsSpinner.setOnItemSelectedListener(this);
        countriesSpinner.setOnItemSelectedListener(this);
        citiesListView.setOnItemClickListener(this);

        adp=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,continents);
        continentsSpinner.setAdapter(adp);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        switch(continent)
        {
            case 0:
                populationTextView.setText("Population: " + populationsAfrica[country][position]);
                areaTextView.setText("Area: " + areasAfrica[country][position]);
                break;
            case 1:
                populationTextView.setText("Population: " + populationsAsia[country][position]);
                areaTextView.setText("Area: " + areasAsia[country][position]);
                break;
            case 2:
                populationTextView.setText("Population: " + populationsEurope[country][position]);
                areaTextView.setText("Area: " + areasEurope[country][position]);
                break;
            case 3:
                populationTextView.setText("Population: " + populationsNAmerica[country][position]);
                areaTextView.setText("Area: " + areasNAmerica[country][position]);
                break;
            case 4:
                populationTextView.setText("Population: " + populationsOceania[country][position]);
                areaTextView.setText("Area: " + areasOceania[country][position]);
                break;
            case 5:
                populationTextView.setText("Population: " + populationsSAmerica[country][position]);
                areaTextView.setText("Area: " + areasSAmerica[country][position]);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        if (parent.getId()==continentsSpinner.getId())
        {
            if (position == 0) return;
            adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, countries[position - 1]);
            countriesSpinner.setAdapter(adp);
            continent=position-1;
        }
        else
        {
            if (position == 0) return;
            country=position-1;

            switch(continent)
            {
                case 0:
                    adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesAfrica[position - 1]);
                    break;
                case 1:
                    adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesAsia[position - 1]);
                    break;
                case 2:
                    adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesEurope[position - 1]);
                    break;
                case 3:
                    adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesNAmerica[position - 1]);
                    break;
                case 4:
                    adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesOceania[position - 1]);
                    break;
                case 5:
                    adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesSAmerica[position - 1]);
                    break;
            }
            citiesListView.setAdapter(adp);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}