package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;

import logica.Arista;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InterfazGrafo
{

	private JFrame frame;
	private JPanel panelMapa;
	private JPanel panelControles;
	private JMapViewer mapa;
	private ArrayList<Coordinate> Coordenadas;
	private MapPolygonImpl poligono;
	private Map<String, Coordinate> provinciasGuardadas = new HashMap<>();
	private List<String> nombreProvincias = new ArrayList<>();
	private List<Arista> AristasUsuario = new ArrayList<>();
	private double cantidadRegiones;
	private JTextField txt_NombreProvincia;
	private JTextField txt_LatitudProvincia;
	private JTextField txt_LongitudProvincia;
	private JTextField PesoArista;
	private JLabel txt_Similaridad;
	private JButton btnSimilaridad;
	private JTextField txt_Regiones;
	private JLabel lblNewLabel;
	private JButton btnGenerarGrafo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					InterfazGrafo window = new InterfazGrafo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazGrafo() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 1180, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelMapa = new JPanel();
		panelMapa.setBounds(0, 0, 627, 729);
		panelMapa.setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(panelMapa);
		
		panelControles = new JPanel();
		panelControles.setBounds(625, 0, 539, 729);
		frame.getContentPane().add(panelControles);		
		panelControles.setLayout(null);
		
		txt_NombreProvincia = new JTextField();
		txt_NombreProvincia.setBounds(25, 55, 86, 20);
		panelControles.add(txt_NombreProvincia);
		txt_NombreProvincia.setColumns(10);
		
		txt_LatitudProvincia = new JTextField();
		txt_LatitudProvincia.setBounds(139, 55, 86, 20);
		panelControles.add(txt_LatitudProvincia);
		txt_LatitudProvincia.setColumns(10);
		
		txt_LongitudProvincia = new JTextField();
		txt_LongitudProvincia.setBounds(254, 55, 86, 20);
		panelControles.add(txt_LongitudProvincia);
		txt_LongitudProvincia.setColumns(10);
		
		JLabel Label_NombreProvincia = new JLabel("Nombre");
		Label_NombreProvincia.setHorizontalAlignment(SwingConstants.CENTER);
		Label_NombreProvincia.setFont(new Font("Tahoma", Font.BOLD, 14));
		Label_NombreProvincia.setBounds(25, 30, 86, 14);
		panelControles.add(Label_NombreProvincia);
		
		JLabel lblLatitud = new JLabel("Latitud");
		lblLatitud.setHorizontalAlignment(SwingConstants.CENTER);
		lblLatitud.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLatitud.setBounds(139, 30, 86, 14);
		panelControles.add(lblLatitud);
		
		JLabel lblLongitud = new JLabel("Longitud");
		lblLongitud.setHorizontalAlignment(SwingConstants.CENTER);
		lblLongitud.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLongitud.setBounds(254, 30, 86, 14);
		panelControles.add(lblLongitud);
		
		JComboBox ListaVerticeOrigen = new JComboBox();
		ListaVerticeOrigen.setBounds(25, 156, 86, 22);
		panelControles.add(ListaVerticeOrigen);
		
		JComboBox ListaVerticeDestino = new JComboBox();
		ListaVerticeDestino.setBounds(139, 156, 86, 22);
		panelControles.add(ListaVerticeDestino);
		
		JButton btnAgregarProvincia = new JButton("Agregar Provincia");
		btnAgregarProvincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String nombreProvincia = txt_NombreProvincia.getText();
				double latitudProvincia = Double.parseDouble(txt_LatitudProvincia.getText());
				double longitudProvincia = Double.parseDouble(txt_LongitudProvincia.getText());
				
				Coordinate ubicacion = new Coordinate(latitudProvincia, longitudProvincia);
				provinciasGuardadas.put(nombreProvincia, ubicacion);
				nombreProvincias.add(nombreProvincia);
				
				MapMarkerDot marcador = new MapMarkerDot(nombreProvincia, ubicacion);
				mapa.addMapMarker(marcador);
				
				ListaVerticeOrigen.addItem(nombreProvincia);
				ListaVerticeDestino.addItem(nombreProvincia);
				
				txt_NombreProvincia.setText("");
				txt_LatitudProvincia.setText("");
				txt_LongitudProvincia.setText("");
				
				
				
				} catch (NumberFormatException excepcion) {
			    JOptionPane.showMessageDialog(null, "La latitud y longitud deben ser valores numéricos.");
				}
			}
		});
		btnAgregarProvincia.setBounds(393, 54, 117, 23);
		panelControles.add(btnAgregarProvincia);
		
		PesoArista = new JTextField();
		PesoArista.setBounds(254, 157, 86, 20);
		panelControles.add(PesoArista);
		PesoArista.setColumns(10);
		
		txt_Similaridad = new JLabel("Similaridad");
		txt_Similaridad.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Similaridad.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_Similaridad.setBounds(254, 130, 86, 14);
		panelControles.add(txt_Similaridad);
		
		btnSimilaridad = new JButton("Conectar");
		btnSimilaridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int verticeOrigen = ListaVerticeOrigen.getSelectedIndex();
				int verticeDestino = ListaVerticeDestino.getSelectedIndex();
				double peso = Double.parseDouble(PesoArista.getText());
				
				AristasUsuario.add(new Arista(verticeOrigen, verticeDestino, peso));
			}
		});
		btnSimilaridad.setBounds(254, 188, 89, 23);
		panelControles.add(btnSimilaridad);
		
		txt_Regiones = new JTextField();
		txt_Regiones.setBounds(25, 289, 86, 20);
		panelControles.add(txt_Regiones);
		txt_Regiones.setColumns(10);
		
		lblNewLabel = new JLabel("Cantidad de regiones");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(25, 243, 86, 35);
		panelControles.add(lblNewLabel);
		
		btnGenerarGrafo = new JButton("Generar");
		btnGenerarGrafo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cantidadRegiones = Double.parseDouble(txt_Regiones.getText());
				//llamar a clase mapa
			}
		});
		btnGenerarGrafo.setBounds(22, 320, 89, 23);
		panelControles.add(btnGenerarGrafo);
		
		
		
	
		
		
		
		mapa = new JMapViewer();
		mapa.setDisplayPosition(new Coordinate(-40, -60), 4);
		
				
		panelMapa.add(mapa, BorderLayout.CENTER);

	}
}

