package fr.esgi.rent.servlets;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RentalPropertiesConsultationServletTest {

    @Test
    public void testDoGet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Setup StringWriter and PrintWriter for capturing servlet output
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        RentalPropertiesConsultationServlet servlet = new RentalPropertiesConsultationServlet();
        servlet.doGet(request, response);

        // verify(response).setContentType("toto");
        writer.flush();

        // Assert that the output is what you expect
        String expectedOutput = "<h1>Liste des locations</h1>"
                + "<ul>"
                + "<li>Appartement à louer</li>"
                + "<li>Description : Appartement spacieux avec vue sur l'ESGI</li>"
                + "<li>Loyer : 750.90 €</li>"
                + "<li>Caution : 1200.90 €</li>"
                + "<li>Surface : 37.48 m²</li>"
                + "</ul>"
                + "<ul>"
                + "<li>Maison à louer</li>"
                + "<li>Description : Maison à louer dans banlieue calme et proche du RER</li>"
                + "<li>Loyer : 1050.90 €</li>"
                + "<li>Caution : 1400.90 €</li>"
                + "<li>Surface : 62.50 m²</li>"
                + "</ul>";

        // Replace all newlines and spaces to handle variations in output formatting
        assertEquals(expectedOutput.replaceAll("\\s+", ""), stringWriter.toString().replaceAll("\\s+", ""));
    }

}
