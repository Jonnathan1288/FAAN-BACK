package com.proyecto.faan.controller.secundary.webSocket;

import com.proyecto.faan.repository.secundary.NotificacionRepository;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.faan.model.secundary.Notificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class NotificacionWebSocketHandler extends TextWebSocketHandler {
    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        System.out.println("Hola --> "+session);
        sessions.add(session);

        List<Notificacion> find = notificacionRepository.findByEstadoNotifacion("A");
        enviarNotificacionesAUsuarios(find);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {

        String payload = message.getPayload();
        JSONObject jsonObject = new JSONObject(payload);
        session.sendMessage(new TextMessage("Hooliii " + jsonObject.get("user")));
    }

    public void enviarNotificacionesAUsuarios(List<Notificacion> notificaciones) {
        System.out.println("Llego---");
        try {
            for (WebSocketSession session : sessions) {
                if (session.isOpen()) {
                    TextMessage message = new TextMessage(objectMapper.writeValueAsString(notificaciones));
                    session.sendMessage(message);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Scheduled(fixedRate = 4000)
    public void enviarNotificacionesPeriodicamente() {
        List<Notificacion> notificaciones = notificacionRepository.findByEstadoNotifacion("A");
        enviarNotificacionesAUsuarios(notificaciones);
    }





}

/*@Component
public class NotificacionWebSocketHandler extends TextWebSocketHandler {
    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("Hola --> "+session);
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    }

    public void enviarNotificaciones(List<Notificacion> notificaciones) throws IOException {
        System.out.println(notificaciones);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonNotificaciones = objectMapper.writeValueAsString(notificaciones);

        for (WebSocketSession session : sessions) {
            System.out.println("Envio-> "+jsonNotificaciones);
            session.sendMessage(new TextMessage(jsonNotificaciones));
        }
    }
}*/
