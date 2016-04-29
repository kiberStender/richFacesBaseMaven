package com.kiber.books.jsf.bean;
 
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import com.kiber.books.jsf.dto.Person;
import org.richfaces.event.ItemChangeEvent;

import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class PanelMenuBean {
    private String current;
    private boolean singleMode;
    private List<SelectItem> select = null;
    private String currentType = "";
    private Person p;
    private Person iP;
    private ArrayList<Person> persons;

    @PostConstruct
    public void init(){
        persons = new ArrayList<>();
        persons.add(new Person(0L, "Kleber", "Stender"));
        persons.add(new Person(1L, "João", "Neto"));
        persons.add(new Person(2L, "Lucas", "Ignácio"));

        select = loadSelect(persons);

        p = new Person();
        iP = new Person();
    }

    private List<SelectItem> loadSelect(List<Person> list){
        List<SelectItem> selectItems = new ArrayList<>();

        for (Person p: list){
            selectItems.add(new SelectItem("" + p.getId(), p.getName()));
        }

        return selectItems;
    }
 
    public boolean isSingleMode() {
        return singleMode;
    }
 
    public void setSingleMode(boolean singleMode) {
        this.singleMode = singleMode;
    }
 
    public String getCurrent() {
        return this.current;
    }
 
    public void setCurrent(String current) {
        this.current = current;
    }
 
    public void updateCurrent(ItemChangeEvent event) {
        System.out.println(event.getNewItemName());

        setCurrent(event.getNewItemName());
    }

    public List<SelectItem> getSelect() {
        return select;
    }

    public void setSelect(List<SelectItem> select) {
        this.select = select;
    }

    public String getCurrentType() {
        return currentType;
    }

    public void setCurrentType(String currentType) {
        this.currentType = currentType;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public Person getiP() {
        return iP;
    }

    public void setiP(Person iP) {
        this.iP = iP;
    }

    public void insertPerson(ActionEvent event) throws AbortProcessingException {
        System.out.println(event.toString());
        System.out.println(persons.size());

        persons.add(persons.size(), iP);

        select = loadSelect(persons);
    }

    public void onItemChange(ValueChangeEvent event){
        String vl = (String) event.getNewValue();

        if(vl != null && !vl.isEmpty()) {
            Long id = Long.parseLong(vl);

            for(Person p_: persons){
                if(p_.getId().equals(id)){
                    p = p_;
                }
            }
        } else {
            System.out.println("Item empty");
        }
    }
}
