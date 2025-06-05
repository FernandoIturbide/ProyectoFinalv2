package mx.unam.aragon.ico.is.formula1api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "coches")
public class Formula1Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clave;

    @Column(name = "nombre_equipo", nullable = false, length = 50)
    private String equipo;

    @Column(name = "modelo_coche", columnDefinition = "VARCHAR(50) not null")
    @NotBlank(message = "El campo no debe tener solo espacios en blanco")
    @NotNull(message = "No debe ser nulo")
    private String modelo;

    @Column(name = "fabricante motor", nullable = false, length = 50)
    private String motor;

    @Column(name = "url_foto", nullable = true, insertable = false, columnDefinition = "VARCHAR(500) DEFAULT 'https://extensions.typo3.org/typo3temp/assets/tx_terfe2/images/placeholder_images_1.1.0.png'")
    private String foto;

    @Column(name = "peso_kilos", nullable = true)
    private Float peso;


    public Formula1Coche() {
    }

    public Formula1Coche(int clave, Float peso, String foto, String motor, String modelo, String equipo) {
        this.clave = clave;
        this.peso = peso;
        this.foto = foto;
        this.motor = motor;
        this.modelo = modelo;
        this.equipo = equipo;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Formula1Coche that = (Formula1Coche) o;
        return clave == that.clave && Objects.equals(equipo, that.equipo) && Objects.equals(modelo, that.modelo) && Objects.equals(motor, that.motor) && Objects.equals(foto, that.foto) && Objects.equals(peso, that.peso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clave, equipo, modelo, motor, foto, peso);
    }

    @Override
    public String toString() {
        return "Formula1Coche{" +
                "clave=" + clave +
                ", equipo='" + equipo + '\'' +
                ", modelo='" + modelo + '\'' +
                ", motor='" + motor + '\'' +
                ", foto='" + foto + '\'' +
                ", peso=" + peso +
                '}';
    }
}
