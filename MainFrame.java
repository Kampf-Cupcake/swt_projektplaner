/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.DefaultListModel;
/**
 *
 * @author Jan Beuster
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    
    public MainFrame() {
        initComponents();
        
    }
ProjektVerwaltung pv = new ProjektVerwaltung();
BenutzerVerwaltung bv = new BenutzerVerwaltung();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RadioButtonGroupRangAuswaehlen = new javax.swing.ButtonGroup();
        Menu = new javax.swing.JPanel();
        ButtonMenuProjektAnlegen = new javax.swing.JButton();
        ButtonMenuBenutzerAnlegen = new javax.swing.JButton();
        ButtonMenuProjekteAnsehen = new javax.swing.JButton();
        ProjektAnlegen = new javax.swing.JPanel();
        LabelName = new javax.swing.JLabel();
        LabelBeschreibung = new javax.swing.JLabel();
        LabelDeadline = new javax.swing.JLabel();
        TextFieldName = new javax.swing.JTextField();
        TextFieldBeschreibung = new javax.swing.JTextField();
        ButtonProjektAnlegen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListeMitarbeiterHinzufügen = new javax.swing.JList<>();
        ButtonMitarbeiterHinzufügen = new javax.swing.JButton();
        LabelMitarbeiter = new javax.swing.JLabel();
        TitelProjektAnlegen = new javax.swing.JLabel();
        ComboBoxTag = new javax.swing.JComboBox<>();
        ComboBoxMonat = new javax.swing.JComboBox<>();
        ComboBoxJahr = new javax.swing.JComboBox<>();
        ButtonBackProjektAnlegen = new javax.swing.JButton();
        BenutzerAnlegen = new javax.swing.JPanel();
        TitelBenutzerAnlegen = new javax.swing.JLabel();
        LabelVorname = new javax.swing.JLabel();
        LabelNachname = new javax.swing.JLabel();
        LabelPasswort = new javax.swing.JLabel();
        LabelRang = new javax.swing.JLabel();
        TextFieldVorname = new javax.swing.JTextField();
        TextFieldNachname = new javax.swing.JTextField();
        TextFieldPasswort = new javax.swing.JTextField();
        RadioButtonStandardBenutzer = new javax.swing.JRadioButton();
        RadioButtonAdministrator = new javax.swing.JRadioButton();
        ButtonBenutzerAnlegen = new javax.swing.JButton();
        ProfilVerwalten = new javax.swing.JPanel();
        ProjekteAnsehen = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListProjekteAnsehen = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        ButtonBackProjekteAnsehen = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListProjektinformationen = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        ProjekteAnsehenSub = new javax.swing.JPanel();
        LabelProjekteAnsehenSub = new javax.swing.JLabel();
        LabelProjektName = new javax.swing.JLabel();
        LabelProjektBeschreibung = new javax.swing.JLabel();
        LabelProjektDeadline = new javax.swing.JLabel();
        TextFieldProjektName = new javax.swing.JTextField();
        TextFieldProjektBeschreibung = new javax.swing.JTextField();
        TextFieldProjektDeadline = new javax.swing.JTextField();
        LabelKommentar = new javax.swing.JLabel();
        TextFieldKommentar = new javax.swing.JTextField();
        TextFieldNotiz = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        ButtonMenuProjektAnlegen.setText("Projekt anlegen");
        ButtonMenuProjektAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMenuProjektAnlegenActionPerformed(evt);
            }
        });

        ButtonMenuBenutzerAnlegen.setText("Benutzer anlegen");
        ButtonMenuBenutzerAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMenuBenutzerAnlegenActionPerformed(evt);
            }
        });

        ButtonMenuProjekteAnsehen.setText("Projekte ansehen");
        ButtonMenuProjekteAnsehen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMenuProjekteAnsehenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonMenuProjekteAnsehen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonMenuProjektAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(ButtonMenuBenutzerAnlegen)
                .addGap(68, 68, 68))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonMenuProjektAnlegen)
                    .addComponent(ButtonMenuBenutzerAnlegen))
                .addGap(18, 18, 18)
                .addComponent(ButtonMenuProjekteAnsehen)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        getContentPane().add(Menu, "card4");

        LabelName.setText("Name");

        LabelBeschreibung.setText("Beschreibung");

        LabelDeadline.setText("Deadline");

        ButtonProjektAnlegen.setText("Anlegen");
        ButtonProjektAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonProjektAnlegenActionPerformed(evt);
            }
        });

        ListeMitarbeiterHinzufügen.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ListeMitarbeiterHinzufügen);

        ButtonMitarbeiterHinzufügen.setText("Hinzufügen");

        LabelMitarbeiter.setText("Mitarbeiter");

        TitelProjektAnlegen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TitelProjektAnlegen.setText("Projekt Anlegen");

        ComboBoxTag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        ComboBoxMonat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember" }));

        ComboBoxJahr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));

        ButtonBackProjektAnlegen.setText("Zurück");
        ButtonBackProjektAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBackProjektAnlegenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProjektAnlegenLayout = new javax.swing.GroupLayout(ProjektAnlegen);
        ProjektAnlegen.setLayout(ProjektAnlegenLayout);
        ProjektAnlegenLayout.setHorizontalGroup(
            ProjektAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProjektAnlegenLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(ProjektAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProjektAnlegenLayout.createSequentialGroup()
                        .addGroup(ProjektAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelName)
                            .addComponent(LabelBeschreibung)
                            .addComponent(LabelDeadline)
                            .addComponent(LabelMitarbeiter))
                        .addGap(57, 57, 57)
                        .addGroup(ProjektAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ButtonMitarbeiterHinzufügen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextFieldName)
                            .addComponent(TextFieldBeschreibung)
                            .addComponent(jScrollPane1)
                            .addComponent(ButtonProjektAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(ProjektAnlegenLayout.createSequentialGroup()
                                .addComponent(ComboBoxTag, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ComboBoxMonat, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboBoxJahr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(55, Short.MAX_VALUE))
                    .addGroup(ProjektAnlegenLayout.createSequentialGroup()
                        .addComponent(TitelProjektAnlegen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonBackProjektAnlegen)
                        .addGap(37, 37, 37))))
        );
        ProjektAnlegenLayout.setVerticalGroup(
            ProjektAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProjektAnlegenLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(ProjektAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitelProjektAnlegen)
                    .addComponent(ButtonBackProjektAnlegen))
                .addGap(29, 29, 29)
                .addGroup(ProjektAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelName)
                    .addComponent(TextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(ProjektAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelBeschreibung)
                    .addComponent(TextFieldBeschreibung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(ProjektAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDeadline)
                    .addComponent(ComboBoxTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxMonat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxJahr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(ProjektAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelMitarbeiter))
                .addGap(18, 18, 18)
                .addComponent(ButtonMitarbeiterHinzufügen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(ButtonProjektAnlegen)
                .addGap(22, 22, 22))
        );

        getContentPane().add(ProjektAnlegen, "card2");

        TitelBenutzerAnlegen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TitelBenutzerAnlegen.setText("Benutzerprofil anlegen");

        LabelVorname.setText("Vorname");

        LabelNachname.setText("Nachname");

        LabelPasswort.setText("Passwort");

        LabelRang.setText("Rang");

        RadioButtonGroupRangAuswaehlen.add(RadioButtonStandardBenutzer);
        RadioButtonStandardBenutzer.setText("Standard Benutzer");

        RadioButtonGroupRangAuswaehlen.add(RadioButtonAdministrator);
        RadioButtonAdministrator.setText("Administrator");

        ButtonBenutzerAnlegen.setText("Anlegen");
        ButtonBenutzerAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBenutzerAnlegenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BenutzerAnlegenLayout = new javax.swing.GroupLayout(BenutzerAnlegen);
        BenutzerAnlegen.setLayout(BenutzerAnlegenLayout);
        BenutzerAnlegenLayout.setHorizontalGroup(
            BenutzerAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BenutzerAnlegenLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(BenutzerAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TitelBenutzerAnlegen)
                    .addGroup(BenutzerAnlegenLayout.createSequentialGroup()
                        .addGroup(BenutzerAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelVorname)
                            .addComponent(LabelNachname)
                            .addComponent(LabelPasswort)
                            .addComponent(LabelRang))
                        .addGap(79, 79, 79)
                        .addGroup(BenutzerAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RadioButtonAdministrator)
                            .addGroup(BenutzerAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TextFieldVorname)
                                .addComponent(TextFieldNachname)
                                .addComponent(TextFieldPasswort)
                                .addComponent(RadioButtonStandardBenutzer))
                            .addComponent(ButtonBenutzerAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        BenutzerAnlegenLayout.setVerticalGroup(
            BenutzerAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BenutzerAnlegenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BenutzerAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BenutzerAnlegenLayout.createSequentialGroup()
                        .addComponent(TitelBenutzerAnlegen)
                        .addGap(43, 43, 43)
                        .addComponent(LabelVorname))
                    .addComponent(TextFieldVorname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BenutzerAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNachname)
                    .addComponent(TextFieldNachname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(BenutzerAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPasswort)
                    .addComponent(TextFieldPasswort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(BenutzerAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelRang)
                    .addComponent(RadioButtonStandardBenutzer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioButtonAdministrator)
                .addGap(40, 40, 40)
                .addComponent(ButtonBenutzerAnlegen)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        getContentPane().add(BenutzerAnlegen, "card3");

        javax.swing.GroupLayout ProfilVerwaltenLayout = new javax.swing.GroupLayout(ProfilVerwalten);
        ProfilVerwalten.setLayout(ProfilVerwaltenLayout);
        ProfilVerwaltenLayout.setHorizontalGroup(
            ProfilVerwaltenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );
        ProfilVerwaltenLayout.setVerticalGroup(
            ProfilVerwaltenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        getContentPane().add(ProfilVerwalten, "card5");

        ProjekteAnsehen.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ProjekteAnsehenComponentShown(evt);
            }
        });

        ListProjekteAnsehen.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ListProjekteAnsehenComponentShown(evt);
            }
        });
        ListProjekteAnsehen.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListProjekteAnsehenValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ListProjekteAnsehen);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Projekte Ansehen");

        ButtonBackProjekteAnsehen.setText("Zurück");
        ButtonBackProjekteAnsehen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBackProjekteAnsehenActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(ListProjektinformationen);

        jButton1.setText("Öffnen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProjekteAnsehenLayout = new javax.swing.GroupLayout(ProjekteAnsehen);
        ProjekteAnsehen.setLayout(ProjekteAnsehenLayout);
        ProjekteAnsehenLayout.setHorizontalGroup(
            ProjekteAnsehenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProjekteAnsehenLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(ProjekteAnsehenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProjekteAnsehenLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ProjekteAnsehenLayout.createSequentialGroup()
                        .addGroup(ProjekteAnsehenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProjekteAnsehenLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                            .addGroup(ProjekteAnsehenLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                                .addComponent(ButtonBackProjekteAnsehen)))
                        .addGap(21, 21, 21))))
        );
        ProjekteAnsehenLayout.setVerticalGroup(
            ProjekteAnsehenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProjekteAnsehenLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(ProjekteAnsehenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(ButtonBackProjekteAnsehen))
                .addGap(59, 59, 59)
                .addGroup(ProjekteAnsehenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(42, 42, 42))
        );

        getContentPane().add(ProjekteAnsehen, "card6");

        LabelProjekteAnsehenSub.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LabelProjekteAnsehenSub.setText("Projekte ansehen");

        LabelProjektName.setText("Name");

        LabelProjektBeschreibung.setText("Beschreibung");

        LabelProjektDeadline.setText("Deadline");

        LabelKommentar.setText("Kommentar");

        jLabel2.setText("Notiz");

        javax.swing.GroupLayout ProjekteAnsehenSubLayout = new javax.swing.GroupLayout(ProjekteAnsehenSub);
        ProjekteAnsehenSub.setLayout(ProjekteAnsehenSubLayout);
        ProjekteAnsehenSubLayout.setHorizontalGroup(
            ProjekteAnsehenSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProjekteAnsehenSubLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(ProjekteAnsehenSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelProjektName)
                    .addComponent(LabelProjektDeadline)
                    .addComponent(LabelProjekteAnsehenSub)
                    .addComponent(LabelProjektBeschreibung)
                    .addComponent(LabelKommentar)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ProjekteAnsehenSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextFieldNotiz, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(TextFieldProjektBeschreibung, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextFieldProjektDeadline, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextFieldProjektName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextFieldKommentar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(114, 114, 114))
        );
        ProjekteAnsehenSubLayout.setVerticalGroup(
            ProjekteAnsehenSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProjekteAnsehenSubLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(LabelProjekteAnsehenSub)
                .addGap(34, 34, 34)
                .addGroup(ProjekteAnsehenSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(ProjekteAnsehenSubLayout.createSequentialGroup()
                        .addComponent(LabelProjektName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelProjektBeschreibung)
                        .addGap(31, 31, 31)
                        .addComponent(LabelProjektDeadline))
                    .addGroup(ProjekteAnsehenSubLayout.createSequentialGroup()
                        .addComponent(TextFieldProjektName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(TextFieldProjektBeschreibung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(TextFieldProjektDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addGroup(ProjekteAnsehenSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelKommentar)
                    .addComponent(TextFieldKommentar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ProjekteAnsehenSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextFieldNotiz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        getContentPane().add(ProjekteAnsehenSub, "card7");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonProjektAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonProjektAnlegenActionPerformed
     int tag = Integer.parseInt((String)ComboBoxTag.getSelectedItem());
     int monat = ComboBoxMonat.getSelectedIndex();
     int jahr = Integer.parseInt((String)ComboBoxJahr.getSelectedItem());
        pv.anlegenProjekt(TextFieldName.getText(), TextFieldBeschreibung.getText(), tag, monat, jahr );  
    }//GEN-LAST:event_ButtonProjektAnlegenActionPerformed

    
    private void ButtonMenuProjektAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMenuProjektAnlegenActionPerformed
    Menu.setVisible(false); 
    ProjektAnlegen.setVisible(true);
   
    }//GEN-LAST:event_ButtonMenuProjektAnlegenActionPerformed

    
    private void ButtonMenuBenutzerAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMenuBenutzerAnlegenActionPerformed
       Menu.setVisible(false);
       BenutzerAnlegen.setVisible(true);
    }//GEN-LAST:event_ButtonMenuBenutzerAnlegenActionPerformed

    
    private void ButtonBenutzerAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBenutzerAnlegenActionPerformed
       String rang = new String();
       
       if(RadioButtonGroupRangAuswaehlen.getSelection().equals(RadioButtonStandardBenutzer.getModel()) )rang = "Standard Benutzer";
       if(RadioButtonGroupRangAuswaehlen.getSelection().equals(RadioButtonAdministrator.getModel()) )rang = "Administrator";
             
       bv.erstelleProfil(TextFieldNachname.getText(), TextFieldVorname.getText(), TextFieldPasswort.getText(), rang);
    }//GEN-LAST:event_ButtonBenutzerAnlegenActionPerformed

    private void ProjekteAnsehenComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ProjekteAnsehenComponentShown
       ListProjekteAnsehen.removeAll();
        List<Projekt> liste = pv.getProjekte();
     
        DefaultListModel ListModel = new DefaultListModel();
       ListProjekteAnsehen.setModel(ListModel);
        for(int i = 0; i <= liste.size(); i++){ 
            ListModel.addElement(liste.get(i).getname());         
        } 
       System.out.println("OK");
        
    }//GEN-LAST:event_ProjekteAnsehenComponentShown

    
    
    
    private void ButtonMenuProjekteAnsehenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMenuProjekteAnsehenActionPerformed
        Menu.setVisible(false);
        ProjekteAnsehen.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_ButtonMenuProjekteAnsehenActionPerformed

    private void ButtonBackProjektAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackProjektAnlegenActionPerformed
        ProjektAnlegen.setVisible(false);
        Menu.setVisible(true);
    }//GEN-LAST:event_ButtonBackProjektAnlegenActionPerformed

    private void ButtonBackProjekteAnsehenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackProjekteAnsehenActionPerformed
       ProjekteAnsehen.setVisible(false);
        Menu.setVisible(true);
    }//GEN-LAST:event_ButtonBackProjekteAnsehenActionPerformed

    private void ListProjekteAnsehenValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListProjekteAnsehenValueChanged
        List<Projekt> projekte = pv.getProjekte();
        DefaultListModel ListModel = new DefaultListModel();
        ListProjektinformationen.setModel(ListModel);
        
        if (!evt.getValueIsAdjusting()) {
            
                  ListModel.addElement(projekte.get(ListProjekteAnsehen.getSelectedIndex()).getbeschreibung());
        
        }
    }//GEN-LAST:event_ListProjekteAnsehenValueChanged

    private void ListProjekteAnsehenComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ListProjekteAnsehenComponentShown

    }//GEN-LAST:event_ListProjekteAnsehenComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      List<Projekt> projekte = pv.getProjekte();
        
      ProjekteAnsehen.setVisible(false);
      ProjekteAnsehenSub.setVisible(true);
     
      TextFieldProjektName.setText(projekte.get(ListProjekteAnsehen.getSelectedIndex()).getname());
      TextFieldProjektBeschreibung.setText(projekte.get(ListProjekteAnsehen.getSelectedIndex()).getbeschreibung());
    
      GregorianCalendar calendar = projekte.get(ListProjekteAnsehen.getSelectedIndex()).getDeadline();
    SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");                                                 //Gibt noch einen Monat weniger an. Fängt hier bei 0 an zu zählen!
    fmt.setCalendar(calendar);
    String dateFormatted = fmt.format(calendar.getTime());          
    

      
      
      TextFieldProjektDeadline.setText(dateFormatted);
    }//GEN-LAST:event_jButton1ActionPerformed
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
                
            }
        });
    }

   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BenutzerAnlegen;
    private javax.swing.JButton ButtonBackProjektAnlegen;
    private javax.swing.JButton ButtonBackProjekteAnsehen;
    private javax.swing.JButton ButtonBenutzerAnlegen;
    private javax.swing.JButton ButtonMenuBenutzerAnlegen;
    private javax.swing.JButton ButtonMenuProjektAnlegen;
    private javax.swing.JButton ButtonMenuProjekteAnsehen;
    private javax.swing.JButton ButtonMitarbeiterHinzufügen;
    private javax.swing.JButton ButtonProjektAnlegen;
    private javax.swing.JComboBox<String> ComboBoxJahr;
    private javax.swing.JComboBox<String> ComboBoxMonat;
    private javax.swing.JComboBox<String> ComboBoxTag;
    private javax.swing.JLabel LabelBeschreibung;
    private javax.swing.JLabel LabelDeadline;
    private javax.swing.JLabel LabelKommentar;
    private javax.swing.JLabel LabelMitarbeiter;
    private javax.swing.JLabel LabelNachname;
    private javax.swing.JLabel LabelName;
    private javax.swing.JLabel LabelPasswort;
    private javax.swing.JLabel LabelProjektBeschreibung;
    private javax.swing.JLabel LabelProjektDeadline;
    private javax.swing.JLabel LabelProjektName;
    private javax.swing.JLabel LabelProjekteAnsehenSub;
    private javax.swing.JLabel LabelRang;
    private javax.swing.JLabel LabelVorname;
    private javax.swing.JList<String> ListProjekteAnsehen;
    private javax.swing.JList<String> ListProjektinformationen;
    private javax.swing.JList<String> ListeMitarbeiterHinzufügen;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel ProfilVerwalten;
    private javax.swing.JPanel ProjektAnlegen;
    private javax.swing.JPanel ProjekteAnsehen;
    private javax.swing.JPanel ProjekteAnsehenSub;
    private javax.swing.JRadioButton RadioButtonAdministrator;
    private javax.swing.ButtonGroup RadioButtonGroupRangAuswaehlen;
    private javax.swing.JRadioButton RadioButtonStandardBenutzer;
    private javax.swing.JTextField TextFieldBeschreibung;
    private javax.swing.JTextField TextFieldKommentar;
    private javax.swing.JTextField TextFieldNachname;
    private javax.swing.JTextField TextFieldName;
    private javax.swing.JTextField TextFieldNotiz;
    private javax.swing.JTextField TextFieldPasswort;
    private javax.swing.JTextField TextFieldProjektBeschreibung;
    private javax.swing.JTextField TextFieldProjektDeadline;
    private javax.swing.JTextField TextFieldProjektName;
    private javax.swing.JTextField TextFieldVorname;
    private javax.swing.JLabel TitelBenutzerAnlegen;
    private javax.swing.JLabel TitelProjektAnlegen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
