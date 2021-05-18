package br.ufpb.barbeariaKlstar.entidades;

public class Data{

    private String dia;
    private String mes;
    private String ano;
    private int hora;
    private int minutos;

    public Data(String dia, String mes, String ano, int hora, int minutos){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
        this.minutos = minutos;
    }
    public String getDia(){
        return this.dia;
    }
    public String getMes(){
        return this.mes;
    }
    public String getAno(){
        return this.ano;
    }
    public int getHora(){
        return this.hora;
    }
    public void setDia(String dia){
        this.dia = dia;
    }
    public void setMes(String mes){
        this.mes = mes;
    }
    public void setAno(String ano){
        this.ano = ano;
    }
    public void setHora(int hora){
        this.hora = hora;
    }
    public void setMinutos(int minutos){
        this.minutos = minutos;
    }

}

    public boolean agendaHorario(Data data, Cliente cliente){
        if(consultaHorario(horario.getData())){
            Horario horario = new Horario(geraCodigoAgendamento(), data, cliente);
            agenda.put(horario.getCodigoAgendamento(), horario);
            return true;
        }return false;
    }

    public boolean consultaData(Data data){
        for(String key: agenda.keySet()){
            if(agenda.get(key).getHorario().getData() == data){
                //A COMPARAÇÃO ESTÁ SUPERFUA, IREI TRATAR DE REFATORAR ESSA CONDICIONAL
                return false;
            }
        }return true;
    }
    public String geraCodigoAgendamento(){
        //TODO
    }

    //ARRAY COM TODOS OS HORARIOS
    HashMap agenda = new HashMap<String, Horario>();

//EXISTE UMA CLASSE DATA QUE CONTEM DIA, MES, ANO, HORA E MINUTOS, A PARTIR DE TODOS OS DADOS, CRIA O OBJ DATA

    if(CLASS_AGENDA_A_CRIAR.agendaHorario(Data data)){
        System.out.println("Agendamento concluido");
    } else {
        //RETORNA A MENSAGEM DE ERRO E FAZ O CLIENTE ALTERAR OS DADOS DE DATA
    }

