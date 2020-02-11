package logbook;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

/**
 * Main runner class to execute the LogBook Project.  
 * @author Alexander Iannuzzi
 * @version 1->5/28/19
 * @copyright Alexander Iannuzzi 5/28/19
 */
@SuppressWarnings("serial")
public class Runner extends JFrame {
    private Container container;
    private JPanel panel;
    private JButton quit;
    private JButton addFlight;
    private JButton viewFlights;
    private JButton stats;
    private JButton certificates;
    private JButton endorsements;
    private JButton personalInfo;
    private GUIPanel mainPanel;
    private FlightReader reader;
    private File log;
    private Calculator calc;
    
    /**
     * Runs the Project.  
     * @param args User Input.  
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException
    {
        File log;
        if (findFile("logbook.txt", new File("C:\\Users\\Alexander Iannuzzi\\git\\LogBook\\LogBook")) == null)
        {
            System.out.println("idk");
            log = new File("logbook.txt");
            log.createNewFile();
        }
        else
        {
            System.out.println("file found");
            log = findFile("logbook.txt", new File("C:\\Users\\Alexander Iannuzzi\\git\\LogBook\\LogBook"));
        }
        
//        File log = new File("logbook.txt");
//        if (log.exists())
//        {
//            log = log.getAbsoluteFile();
//            PrintWriter thing = new PrintWriter(log);
//            thing.println("wrong");
//        }
//        else
//        {
//            log.createNewFile();
//        }
//        if (!log.toString()
//            .substring(log.toString().length() - 3).equals("txt"))
//        {
//            throw new IllegalArgumentException("File is either not a file or "
//                + "is not a .txt file");
//        }
        
        @SuppressWarnings("unused")
        Runner frame = new Runner(log);
    }
    
    
    public static File findFile(String fileName, File directory)
    {
        File[] list = directory.listFiles();
        if(list != null)
        for (File fil : list)
        {
            if (fil.isDirectory())
            {
                findFile(fileName, fil);
                System.out.println(fil.getName());
            }
            else if (fileName.equalsIgnoreCase(fil.getName()))
            {
                return fil;
            }
        }
        return null;
    }
    
    /**
     * Constructor for the GUIWindow class.  
     * @throws FileNotFoundException 
     */
    public Runner(File file) throws FileNotFoundException
    {
        super("LogBook");
        this.log = file;
        reader = new FlightReader(file);
        LinkedList<Flight> logs = reader.readFile();
        System.out.println(logs.getSize());
        calc = new Calculator(logs);
        calc.calculate();
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1000, 700);
        setResizable(false);
        container = getContentPane();
        panel = new JPanel();
        mainPanel = new GUIPanel();
        mainPanel.setLayout(null);
        panel.setBackground(new Color(0, 0, 128));
        mainPanel.setBackground(new Color(250, 235, 215));
        container.add(panel, BorderLayout.NORTH);
        container.add(mainPanel, BorderLayout.CENTER);
        quit = new JButton("Save and Exit");
        addFlight = new JButton("Add Flight");
        viewFlights = new JButton("Flight Log");
        stats = new JButton("Statistics");
        certificates = new JButton("Certifications");
        endorsements = new JButton("Endorsements");
        personalInfo = new JButton("Pilot Info");
        panel.add(addFlight);
        panel.add(viewFlights);
        panel.add(stats);
        panel.add(certificates);
        panel.add(endorsements);
        panel.add(personalInfo);
        panel.add(quit);
        setVisible(true);
        
        quit.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    reader.recordFlights(calc.getFlights());
                    System.exit(0);
                }
            });
        
        stats.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    showStats();
                }
            });
        
        viewFlights.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg0)
                {
                    showLog();
                }
                
                
            });
        
        addFlight.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                addFlight();
            }
        });
        
        addFlight();
    }
    
    /**
     * Generates the add flight window on the GUI.  
     */
    public void addFlight()
    {
        mainPanel.removeAll();
        mainPanel.updateUI();
        mainPanel.drawing("add", null);
        JPanel errorPanel = new JPanel();
        errorPanel.setLayout(null);
        errorPanel.setBackground(new Color(250, 235, 215));
        mainPanel.add(errorPanel);
        errorPanel.setSize(400, 150);
        errorPanel.setLocation(450, 375);
        
        JLabel thing = new JLabel("Add Flight");
        thing.setFont(new Font("Arial", 1, 27));
        mainPanel.add(thing);
        thing.setSize(200, 30);
        thing.setLocation(20, 15);
        
        //date
        JTextField a = new JTextField();
        
        //aircraft
        JTextField b = new JTextField();
        
        //id
        JTextField c = new JTextField();
        
        //dep/arr
        JTextField d = new JTextField();
        JTextField e = new JTextField();
        
        JTextField i = new JTextField();
        
        JTextField j = new JTextField();
        
        JTextField l = new JTextField();
        JTextField m = new JTextField();
        JTextField n = new JTextField();
        JTextField o = new JTextField();
        JTextField p = new JTextField();
        
        mainPanel.add(a);
        mainPanel.add(b);
        mainPanel.add(c);
        mainPanel.add(d);
        mainPanel.add(e);
        mainPanel.add(i);
        mainPanel.add(j);
        mainPanel.add(l);
        mainPanel.add(m);
        mainPanel.add(n);
        mainPanel.add(o);
        mainPanel.add(p);
        
        a.setSize(100, 25);
        b.setSize(150, 25);
        c.setSize(150, 25);
        d.setSize(70, 25);
        e.setSize(70, 25);
        i.setSize(50, 25);
        j.setSize(50, 25);
        l.setSize(250, 25);
        m.setSize(500, 25);
        n.setSize(70, 25);
        o.setSize(70, 25);
        p.setSize(70, 25);
        
        a.setLocation(20, 100);//date
        JLabel al = new JLabel("Date (XX/XX/XXXX)");
        mainPanel.add(al);
        al.setSize(500, 20);
        al.setFont(new Font("Arial", 1, 12));
        al.setLocation(20, 80);
        b.setLocation(150, 100);//model
        JLabel bl = new JLabel("Aircraft Model");
        mainPanel.add(bl);
        bl.setSize(500, 20);
        bl.setFont(new Font("Arial", 1, 12));
        bl.setLocation(150, 80);
        c.setLocation(350, 100);//registration
        JLabel cl = new JLabel("Aircraft Registration");
        mainPanel.add(cl);
        cl.setSize(500, 20);
        cl.setFont(new Font("Arial", 1, 12));
        cl.setLocation(350, 80);
        d.setLocation(550, 100);//from
        JLabel dl = new JLabel("DEP Airport");
        mainPanel.add(dl);
        dl.setSize(500, 20);
        dl.setFont(new Font("Arial", 1, 12));
        dl.setLocation(550, 80);
        e.setLocation(670, 100);//to
        JLabel el = new JLabel("ARR Airport");
        mainPanel.add(el);
        el.setSize(500, 20);
        el.setFont(new Font("Arial", 1, 12));
        el.setLocation(670, 80);
        l.setLocation(20, 200);//stops
        JLabel ll = new JLabel("Stops (Separated by \",\" No Spaces)");
        mainPanel.add(ll);
        ll.setSize(500, 20);
        ll.setFont(new Font("Arial", 1, 12));
        ll.setLocation(20, 180);
        i.setLocation(20, 300);//instrument landings
        JLabel il = new JLabel("No. Instr. Approaches");
        mainPanel.add(il);
        il.setSize(500, 20);
        il.setFont(new Font("Arial", 1, 12));
        il.setLocation(20, 280);
        j.setLocation(170, 300);//landings
        JLabel jl = new JLabel("No. Landings");
        mainPanel.add(jl);
        jl.setSize(500, 20);
        jl.setFont(new Font("Arial", 1, 12));
        jl.setLocation(170, 280);
        m.setLocation(320, 300);//remarks
        JLabel ml = new JLabel("Remarks");
        mainPanel.add(ml);
        ml.setSize(500, 20);
        ml.setFont(new Font("Arial", 1, 12));
        ml.setLocation(320, 280);
        n.setLocation(500, 200);//cat time
        JLabel nl = new JLabel("Aircraft Category");
        mainPanel.add(nl);
        nl.setSize(500, 20);
        nl.setFont(new Font("Arial", 1, 12));
        nl.setLocation(300, 180);
        JLabel nnl = new JLabel("Time");
        mainPanel.add(nnl);
        nnl.setSize(500, 20);
        nnl.setFont(new Font("Arial", 1, 12));
        nnl.setLocation(500, 180);
        o.setLocation(850, 200);//type time
        JLabel ol = new JLabel("Type Category");
        mainPanel.add(ol);
        ol.setSize(500, 20);
        ol.setFont(new Font("Arial", 1, 12));
        ol.setLocation(650, 180);
        JLabel ool = new JLabel("Time");
        mainPanel.add(ool);
        ool.setSize(500, 20);
        ool.setFont(new Font("Arial", 1, 12));
        ool.setLocation(850, 180);
        p.setLocation(220, 400);//condition time
        JLabel pl = new JLabel("Flight Condition");
        mainPanel.add(pl);
        pl.setSize(500, 20);
        pl.setFont(new Font("Arial", 1, 12));
        pl.setLocation(20, 380);
        JLabel ppl = new JLabel("Time");
        mainPanel.add(ppl);
        ppl.setSize(500, 20);
        ppl.setFont(new Font("Arial", 1, 12));
        ppl.setLocation(220, 380);
        
        
        
        Stack<String> errors = new Stack<String>();
        JButton confirm = new JButton("Confirm");
        mainPanel.add(confirm);
        confirm.setSize(120, 30);
        confirm.setLocation(440, 550);
        
        //ComboBox
        String[] classes = {"Single Engine", "Multi Engine", "Rotor"};
        JComboBox<String> cat = new JComboBox<String>(classes);
        mainPanel.add(cat);
        cat.setSize(170, 25);
        cat.setLocation(300, 200);
        
        String[] typeTime = {"Dual", "Pilot in Command", 
            "Second in Command", "Flight Instructor", "Ground Instructor"};
        JComboBox<String> type = new JComboBox<String>(typeTime);
        mainPanel.add(type);
        type.setSize(180, 25);
        type.setLocation(650, 200);
        
        String[] conditions = {"Day", "Night", "Cross Country", 
            "Actual Instrument", "Simulated Instrument"};
        JComboBox<String> cond = new JComboBox<String>(conditions);
        mainPanel.add(cond);
        cond.setSize(180, 25);
        cond.setLocation(20, 400);
        
        mainPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x=e.getX();
                int y=e.getY();
                System.out.println(x+","+y);//these co-ords are relative to the component
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub
                
            }
        });
        
        confirm.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                errorPanel.removeAll();
                errorPanel.updateUI();
                
                boolean thing = true;
                if ((a.getText().length() == 0 || a.getText().length() > 10 ||a.getText().length() < 8) 
                    || (a.getText().indexOf("/") != 1 && a.getText().indexOf("/") != 2) 
                    || (a.getText().substring(a.getText().indexOf("/") + 1).indexOf("/") != 1 
                    && a.getText().substring(a.getText().indexOf("/") + 1).indexOf("/") != 2)
                    || ((a.getText().substring(0, a.getText().indexOf("/")).length() == 1 
                    && a.getText().substring(0, 1).equals("0"))) 
                    || ((a.getText().substring(0, a.getText().indexOf("/")).length() == 2 
                        && a.getText().substring(0, 2).equals("00"))) || 
                    (a.getText().substring(a.getText().indexOf("/") + 1, a.getText().indexOf("/") + 3).charAt(1) == '/'
                        && a.getText().substring(a.getText().indexOf("/") + 1, a.getText().indexOf("/") + 3).charAt(0) == '0')
                    || (a.getText().substring(a.getText().indexOf("/") + 1, a.getText().indexOf("/") + 4).charAt(2) == '/'
                        && a.getText().substring(a.getText().indexOf("/") + 1, a.getText().indexOf("/") + 4).equals("00/"))
                    || (a.getText().substring(a.getText().length() - 4).contains("/"))
                        || (Integer.parseInt(a.getText().substring(a.getText().length() - 4)) == 0))
                {
                    thing = false;
                    errors.push("Date Format Incorrect");
                    JLabel ast = new JLabel("*");
                    mainPanel.add(ast);
                    ast.setSize(500, 20);
                    ast.setFont(new Font("Arial", 1, 12));
                    ast.setLocation(5, 105);
                }
                
                if (b.getText().length() == 0 || c.getText().length() == 0 
                    || d.getText().length() == 0 || e.getText().length() == 0)
                {
                    thing = false;
                    errors.push("1 or More Fields are Empty");
                }
                
                if (b.getText().length() == 0)
                {
                    JLabel ast = new JLabel("*");
                    mainPanel.add(ast);
                    ast.setSize(500, 20);
                    ast.setBackground(Color.RED);
                    ast.setFont(new Font("Arial", 1, 12));
                    ast.setLocation(135, 105);
                }
                
                if (c.getText().length() == 0)
                {
                    JLabel ast = new JLabel("*");
                    mainPanel.add(ast);
                    ast.setSize(500, 20);
                    ast.setFont(new Font("Arial", 1, 12));
                    ast.setLocation(330, 105);
                }
                
                if (d.getText().length() == 0)
                {
                    JLabel ast = new JLabel("*");
                    mainPanel.add(ast);
                    ast.setSize(500, 20);
                    ast.setFont(new Font("Arial", 1, 12));
                    ast.setLocation(530, 105);
                }
                
                if (e.getText().length() == 0)
                {
                    JLabel ast = new JLabel("*");
                    mainPanel.add(ast);
                    ast.setSize(500, 20);
                    ast.setFont(new Font("Arial", 1, 12));
                    ast.setLocation(655, 105);
                }
                
                if (l.getText().contains(" "))
                {
                    thing = false;
                    errors.push("Stops Field Contains Uneeded Spaces");
                    JLabel ast = new JLabel("*");
                    mainPanel.add(ast);
                    ast.setSize(500, 20);
                    ast.setFont(new Font("Arial", 1, 12));
                    ast.setLocation(10, 205);
                }
                
                if (!isInteger(i.getText()) || !isInteger(j.getText()) 
                    || !isDouble(n.getText()) || !isDouble(o.getText()) 
                    || !isDouble(p.getText()) || i.getText().contains(" ") 
                    || j.getText().contains(" ") || n.getText().contains(" ")
                    || o.getText().contains(" ") || p.getText().contains(" "))
                {
                    thing = false;
                    errors.push("1 or More Fields Contain Characters Instead of Numbers");
                }
                
                if (!isInteger(i.getText()) || i.getText().contains(" "))
                {
                    JLabel ast = new JLabel("*");
                    mainPanel.add(ast);
                    ast.setSize(500, 20);
                    ast.setFont(new Font("Arial", 1, 12));
                    ast.setLocation(5, 305);
                }
                
                if (!isInteger(j.getText()) || j.getText().contains(" "))
                {
                    JLabel ast = new JLabel("*");
                    mainPanel.add(ast);
                    ast.setSize(500, 20);
                    ast.setFont(new Font("Arial", 1, 12));
                    ast.setLocation(155, 305);
                }
                
                if (!isDouble(n.getText()) || n.getText().contains(" "))
                {
                    JLabel ast = new JLabel("*");
                    mainPanel.add(ast);
                    ast.setSize(500, 20);
                    ast.setFont(new Font("Arial", 1, 12));
                    ast.setLocation(485, 205);
                }
                
                if (!isDouble(o.getText()) || o.getText().contains(" "))
                {
                    JLabel ast = new JLabel("*");
                    mainPanel.add(ast);
                    ast.setSize(500, 20);
                    ast.setFont(new Font("Arial", 1, 12));
                    ast.setLocation(840, 205);
                }
                
                if (!isDouble(p.getText()) || p.getText().contains(" "))
                {
                    JLabel ast = new JLabel("*");
                    mainPanel.add(ast);
                    ast.setSize(500, 20);
                    ast.setFont(new Font("Arial", 1, 12));
                    ast.setLocation(210, 405);
                }
                
                if (thing)
                {
                    double single = 0.0;
                    double multi = 0.0;
                    double rotor = 0.0;
                    double dual = 0.0;
                    double pic = 0.0;
                    double sic = 0.0;
                    double cfi = 0.0;
                    double gi = 0.0;
                    double day = 0.0;
                    double night = 0.0;
                    double xco = 0.0;
                    double act = 0.0;
                    double sim = 0.0;
                    
                    if (cat.getSelectedItem().equals("Single Engine"))
                    {
                        single = Double.parseDouble(n.getText());
                        multi = 0.0;
                        rotor = 0.0;
                    }
                    else if (cat.getSelectedItem().equals("Multi Engine"))
                    {
                        multi = Double.parseDouble(n.getText());
                        single = 0.0;
                        rotor = 0.0;
                    }
                    else
                    {
                        rotor = Double.parseDouble(n.getText());
                        single = 0.0;
                        multi = 0.0;
                    }
                    
                    
                    if (type.getSelectedItem().equals("Dual"))
                    {
                        dual = Double.parseDouble(o.getText());
                        pic = 0.0;
                        sic = 0.0;
                        cfi = 0.0;
                        gi = 0.0;
                    }
                    else if (type.getSelectedItem().equals("Pilot in Command"))
                    {
                        pic = Double.parseDouble(o.getText());
                        sic = 0.0;
                        cfi = 0.0;
                        gi = 0.0;
                        dual = 0.0;
                    }
                    else if (type.getSelectedItem().equals("Second in Command"))
                    {
                        sic = Double.parseDouble(o.getText());
                        pic = 0.0;
                        cfi = 0.0;
                        gi = 0.0;
                        dual = 0.0;
                    }
                    else if (type.getSelectedItem().equals("Flight Instructor"))
                    {
                        cfi = Double.parseDouble(o.getText());
                        pic = 0.0;
                        gi = 0.0;
                        dual = 0.0;
                        sic = 0.0;
                    }
                    else
                    {
                        gi = Double.parseDouble(o.getText());
                        pic = 0.0;
                        sic = 0.0;
                        gi = 0.0;
                        dual = 0.0;
                    }
                    
                    if (cond.getSelectedItem().equals("Day"))
                    {
                        day = Double.parseDouble(p.getText());
                        night = 0.0;
                        xco = 0.0;
                        act = 0.0;
                        sim = 0.0;
                    }
                    else if (cond.getSelectedItem().equals("Night"))
                    {
                        night = Double.parseDouble(p.getText());
                        day = 0.0;
                        xco = 0.0;
                        act = 0.0;
                        sim = 0.0;
                    }
                    else if (cond.getSelectedItem().equals("Cross Country"))
                    {
                        xco = Double.parseDouble(p.getText());
                        day = 0.0;
                        night = 0.0;
                        act = 0.0;
                        sim = 0.0;
                    }
                    else if (cond.getSelectedItem().equals("Actual Instrument"))
                    {
                        act = Double.parseDouble(p.getText());
                        day = 0.0;
                        night = 0.0;
                        xco = 0.0;
                        sim = 0.0;
                    }
                    else
                    {
                        sim = Double.parseDouble(p.getText());
                        day = 0.0;
                        night = 0.0;
                        xco = 0.0;
                        act = 0.0;
                    }
                    
                    calc.updateAddFlight(new Flight(a.getText(), b.getText(), c.getText(), 
                        d.getText(), e.getText(), l.getText().split(",").length, single, 
                        multi, rotor, dual, pic, sic, cfi, gi, day, night, xco, act, sim, 
                        Integer.parseInt(i.getText()), Integer.parseInt(j.getText()), 
                        m.getText(), l.getText()));
                    reader.recordFlights(calc.getFlights());
                }
                else
                {
                    
                    int counter = 0;
                    while (!errors.isEmpty() || counter > 5)
                    {
                        String str = errors.pop();
                        JLabel err = new JLabel(str);
                        errorPanel.add(err);
                        err.setSize(500, 20);
                        err.setFont(new Font("Arial", 1, 12));
                        err.setLocation(10, (counter * 30) + 10);
                        counter++;
                    }
                }
                
            }
        });
    }
    
    /**
     * Generates the statistics window on the GUI.  
     */
    public void showStats()
    {
        mainPanel.removeAll();
        mainPanel.updateUI();
        JLabel thing = new JLabel("Statistics Menu");
        thing.setFont(new Font("Arial", 1, 27));
        mainPanel.add(thing);
        thing.setSize(200, 25);
        thing.setLocation(20, 15);
        
        JLabel flightHours = new JLabel("Total Flight Hours");
        flightHours.setFont(new Font("Arial", 1, 20));
        mainPanel.add(flightHours);
        flightHours.setSize(200, 25);
        flightHours.setLocation(20, 50);
        
        JLabel planeType = new JLabel("Airplanes Flown");
        planeType.setFont(new Font("Arial", 1, 20));
        mainPanel.add(planeType);
        planeType.setSize(200, 25);
        planeType.setLocation(20, 165);
        
        JLabel ratings = new JLabel("Ratings");
        ratings.setFont(new Font("Arial", 1, 20));
        mainPanel.add(ratings);
        ratings.setSize(200, 25);
        ratings.setLocation(20, 430);
        
        JLabel recents = new JLabel("Most Recent Flights");
        recents.setFont(new Font("Arial", 1, 20));
        mainPanel.add(recents);
        recents.setSize(200, 25);
        recents.setLocation(525, 165);
        
        //Most recent flight labels
        JLabel a = new JLabel("Date");
        JLabel b = new JLabel("Aircraft");
        JLabel c = new JLabel("From");
        JLabel d = new JLabel("To");
        JLabel e = new JLabel("Time Logged");
        JLabel f = new JLabel("Registration");
        a.setFont(new Font("Arial", 1, 15));
        b.setFont(new Font("Arial", 1, 15));
        c.setFont(new Font("Arial", 1, 15));
        d.setFont(new Font("Arial", 1, 15));
        e.setFont(new Font("Arial", 1, 15));
        f.setFont(new Font("Arial", 1, 15));
        mainPanel.add(a);
        mainPanel.add(b);
        mainPanel.add(c);
        mainPanel.add(d);
        mainPanel.add(e);
        mainPanel.add(f);
        a.setSize(200, 15);
        b.setSize(200, 15);
        c.setSize(200, 15);
        d.setSize(200, 15);
        e.setSize(200, 15);
        f.setSize(200, 15);
        a.setLocation(300, 200);
        b.setLocation(400, 200);
        c.setLocation(525, 200);
        d.setLocation(650, 200);
        e.setLocation(740, 200);
        f.setLocation(880, 200);
        
        mainPanel.drawing("stats", null);
    }
    
    /**
     * Generates the logbook view for the GUI.  
     */
    public void showLog()
    {
        mainPanel.removeAll();
        mainPanel.updateUI();
        
        
        JLabel thing = new JLabel("Flight Log");
        thing.setFont(new Font("Arial", 1, 27));
        mainPanel.add(thing);
        thing.setSize(200, 40);
        thing.setLocation(20, 5);
        
        //labels for all the columns
        JLabel a = new JLabel("Date");
        JLabel b = new JLabel("Model");
        JLabel c = new JLabel("Registration");
        JLabel d = new JLabel("From");
        JLabel e = new JLabel("To");
        JLabel f = new JLabel("Category");
        JLabel g = new JLabel("and Class");
        JLabel h = new JLabel("Type of");
        JLabel i = new JLabel("Pilot Time");
        JLabel j = new JLabel("Flight");
        JLabel k = new JLabel("Conditions");
        JLabel l = new JLabel("No. Instr");
        JLabel m = new JLabel("APP");
        JLabel n = new JLabel("No. LDG");
        JLabel o = new JLabel("Total Flight");
        JLabel p = new JLabel("Duration");
        JLabel q = new JLabel("Stops");
        JLabel r = new JLabel("Remarks");
        JLabel s = new JLabel("View/Edit");
        
        a.setFont(new Font("Arial", 1, 12));
        b.setFont(new Font("Arial", 1, 12));
        c.setFont(new Font("Arial", 1, 12));
        d.setFont(new Font("Arial", 1, 12));
        e.setFont(new Font("Arial", 1, 12));
        f.setFont(new Font("Arial", 1, 12));
        g.setFont(new Font("Arial", 1, 12));
        h.setFont(new Font("Arial", 1, 12));
        i.setFont(new Font("Arial", 1, 12));
        j.setFont(new Font("Arial", 1, 12));
        k.setFont(new Font("Arial", 1, 12));
        l.setFont(new Font("Arial", 1, 12));
        m.setFont(new Font("Arial", 1, 12));
        n.setFont(new Font("Arial", 1, 12));
        o.setFont(new Font("Arial", 1, 12));
        p.setFont(new Font("Arial", 1, 12));
        q.setFont(new Font("Arial", 1, 12));
        r.setFont(new Font("Arial", 1, 12));
        s.setFont(new Font("Arial", 1, 12));
        
        mainPanel.add(a);
        mainPanel.add(b);
        mainPanel.add(c);
        mainPanel.add(d);
        mainPanel.add(e);
        mainPanel.add(f);
        mainPanel.add(g);
        mainPanel.add(h);
        mainPanel.add(i);
        mainPanel.add(j);
        mainPanel.add(k);
        mainPanel.add(l);
        mainPanel.add(m);
        mainPanel.add(n);
        mainPanel.add(o);
        mainPanel.add(p);
        mainPanel.add(q);
        mainPanel.add(r);
        mainPanel.add(s);
        
        a.setSize(150, 20);
        b.setSize(150, 20);
        c.setSize(150, 20);
        d.setSize(150, 20);
        e.setSize(150, 20);
        f.setSize(150, 20);
        g.setSize(150, 20);
        h.setSize(150, 20);
        i.setSize(150, 20);
        j.setSize(150, 20);
        k.setSize(150, 20);
        l.setSize(150, 20);
        m.setSize(150, 20);
        n.setSize(150, 20);
        o.setSize(150, 20);
        p.setSize(150, 20);
        q.setSize(150, 20);
        r.setSize(150, 20);
        s.setSize(150, 20);
        
        a.setLocation(20, 95);
        b.setLocation(90, 95);
        c.setLocation(141, 95);
        d.setLocation(225, 95);
        e.setLocation(292, 95);
        f.setLocation(335, 85);
        g.setLocation(332, 100);
        h.setLocation(400, 85);
        i.setLocation(392, 100);
        j.setLocation(465, 85);
        k.setLocation(451, 100);
        l.setLocation(511, 85);
        m.setLocation(523, 100);
        n.setLocation(562, 95);
        o.setLocation(615, 85);
        p.setLocation(622, 100);
        q.setLocation(693, 95);
        r.setLocation(745, 95);
        s.setLocation(935, 95);
        
        System.out.println(calc.getFlights().getSize());
        for (int count = 0; count < calc.getFlights().getSize(); count++)
        {
            System.out.println(calc.getFlights().get(count).toString());
        }
        showPage(0);
        //implement the display feature here once a data structure 
        //and sorting algorithms are completed.  
    }
    
    
    public void showPage(int num)
    {
        LinkedList<Flight> flights = calc.getFlights();
        int currentIndex = num * 17;
        int startX = 5;
        int startY = 125;
        int endIndex = currentIndex + 17;
        LinkedList<Color> colors = new LinkedList<Color>();
        
        
        while (currentIndex != endIndex && 
            currentIndex < flights.getSize())
        {
            switch (flights.get(currentIndex).getAircraftCategory())
            {
                case MULTI : colors.add(Color.RED);
                JLabel category = new JLabel("" + flights.get(currentIndex).getMultiTime());
                mainPanel.add(category);
                category.setFont(new Font("Arial", 1, 12));
                category.setSize(100, 25);
                category.setLocation(startX + 330, startY);
                break;
                case SINGLE : colors.add(Color.BLUE);
                JLabel category2 = new JLabel("" + flights.get(currentIndex).getSingleTime());
                mainPanel.add(category2);
                category2.setFont(new Font("Arial", 1, 12));
                category2.setSize(100, 25);
                category2.setLocation(startX + 330, startY);
                break;
                default : colors.add(Color.YELLOW);
                JLabel category3 = new JLabel("" + flights.get(currentIndex).getRotorTime());
                mainPanel.add(category3);
                category3.setFont(new Font("Arial", 1, 12));
                category3.setSize(100, 25);
                category3.setLocation(startX + 330, startY);
                break;
            }
            switch (flights.get(currentIndex).getTypeCategory())
            {
                case DUAL : colors.add(Color.RED);
                JLabel type = new JLabel("" + flights.get(currentIndex).getDual());
                mainPanel.add(type);
                type.setFont(new Font("Arial", 1, 12));
                type.setSize(100, 25);
                type.setLocation(startX + 390, startY);
                break;
                case PIC : colors.add(Color.BLUE);
                JLabel type2 = new JLabel("" + flights.get(currentIndex).getPic());
                mainPanel.add(type2);
                type2.setFont(new Font("Arial", 1, 12));
                type2.setSize(100, 25);
                type2.setLocation(startX + 390, startY);
                break;
                case SIC : colors.add(Color.YELLOW);
                JLabel type3 = new JLabel("" + flights.get(currentIndex).getSin());
                mainPanel.add(type3);
                type3.setFont(new Font("Arial", 1, 12));
                type3.setSize(100, 25);
                type3.setLocation(startX + 390, startY);
                break;
                case CFI : colors.add(Color.GREEN);
                JLabel type4 = new JLabel("" + flights.get(currentIndex).getCfi());
                mainPanel.add(type4);
                type4.setFont(new Font("Arial", 1, 12));
                type4.setSize(100, 25);
                type4.setLocation(startX + 390, startY);
                break;
                default : colors.add(Color.ORANGE);
                JLabel type5 = new JLabel("" + flights.get(currentIndex).getGi());
                mainPanel.add(type5);
                type5.setFont(new Font("Arial", 1, 12));
                type5.setSize(100, 25);
                type5.setLocation(startX + 390, startY);
                break;
            }
            switch (flights.get(currentIndex).getFlightCondition())
            {
                case DAY : colors.add(Color.RED);
                JLabel condition = new JLabel("" + flights.get(currentIndex).getDay());
                mainPanel.add(condition);
                condition.setFont(new Font("Arial", 1, 12));
                condition.setSize(100, 25);
                condition.setLocation(startX + 450, startY);
                break;
                case NIGHT : colors.add(Color.BLUE);
                JLabel condition2 = new JLabel("" + flights.get(currentIndex).getNight());
                mainPanel.add(condition2);
                condition2.setFont(new Font("Arial", 1, 12));
                condition2.setSize(100, 25);
                condition2.setLocation(startX + 450, startY);
                break;
                case ACTUAL_INSTRUMENT : colors.add(Color.YELLOW);
                JLabel condition3 = new JLabel("" + flights.get(currentIndex).getActualInstr());
                mainPanel.add(condition3);
                condition3.setFont(new Font("Arial", 1, 12));
                condition3.setSize(100, 25);
                condition3.setLocation(startX + 450, startY);
                break;
                case SIMULATED_INSTRUMENT : colors.add(Color.GREEN);
                JLabel condition4 = new JLabel("" + flights.get(currentIndex).getSimIntr());
                mainPanel.add(condition4);
                condition4.setFont(new Font("Arial", 1, 12));
                condition4.setSize(100, 25);
                condition4.setLocation(startX + 450, startY);
                break;
                default : colors.add(Color.ORANGE);
                JLabel condition5 = new JLabel("" + flights.get(currentIndex).getXcountry());
                mainPanel.add(condition5);
                condition5.setFont(new Font("Arial", 1, 12));
                condition5.setSize(100, 25);
                condition5.setLocation(startX + 450, startY);
                break;
            }
            
            JLabel date = new JLabel(flights.get(currentIndex).getDate());
            mainPanel.add(date);
            date.setFont(new Font("Arial", 1, 12));
            date.setSize(100, 25);
            date.setLocation(startX, startY);
            JLabel model = new JLabel(flights.get(currentIndex).getModel());
            mainPanel.add(model);
            model.setFont(new Font("Arial", 1, 12));
            model.setSize(100, 25);
            model.setLocation(startX + 70, startY);
            JLabel reg = new JLabel(flights.get(currentIndex).getId());
            mainPanel.add(reg);
            reg.setFont(new Font("Arial", 1, 12));
            reg.setSize(100, 25);
            reg.setLocation(startX + 140, startY);
            JLabel from = new JLabel(flights.get(currentIndex).getDep());
            mainPanel.add(from);
            from.setFont(new Font("Arial", 1, 12));
            from.setSize(100, 25);
            from.setLocation(startX + 210, startY);
            JLabel to = new JLabel(flights.get(currentIndex).getArr());
            mainPanel.add(to);
            to.setFont(new Font("Arial", 1, 12));
            to.setSize(100, 25);
            to.setLocation(startX + 270, startY);
            
            
            
            JLabel instr = new JLabel("" + flights.get(currentIndex).getNumInstrApp());
            mainPanel.add(instr);
            instr.setFont(new Font("Arial", 1, 12));
            instr.setSize(100, 25);
            instr.setLocation(startX + 520, startY);
            JLabel land = new JLabel("" + flights.get(currentIndex).getNumLand());
            mainPanel.add(land);
            land.setFont(new Font("Arial", 1, 12));
            land.setSize(100, 25);
            land.setLocation(startX + 565, startY);
            JLabel tot = new JLabel("" + flights.get(currentIndex).getTotalTime());
            mainPanel.add(tot);
            tot.setFont(new Font("Arial", 1, 12));
            tot.setSize(100, 25);
            tot.setLocation(startX + 615, startY);
            JLabel remarks = new JLabel(flights.get(currentIndex).getRemarks());
            mainPanel.add(remarks);
            remarks.setFont(new Font("Arial", 1, 12));
            remarks.setSize(100, 25);
            remarks.setLocation(startX + 740, startY);
            
            
            currentIndex++;
            startY += 30;
        }
        mainPanel.drawing("log", colors);
    }
    
    /**
     * Determines whether of not a String is an integer
     * @param str
     * @return
     */
    public boolean isInteger(String str)
    {
        try 
        {
            Integer.parseInt(str);
        } 
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    
    /**
     * Determines whether of not a String is a double
     * @param str
     * @return
     */
    public boolean isDouble(String str)
    {
        try 
        {
            Double.parseDouble(str);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
}