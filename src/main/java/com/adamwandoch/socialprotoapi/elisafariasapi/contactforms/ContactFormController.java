package com.adamwandoch.socialprotoapi.elisafariasapi.contactforms;

import com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.service.EmailService;
import com.adamwandoch.socialprotoapi.elisafariasapi.subscribers.SubscriberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;

import static com.adamwandoch.socialprotoapi.validation.EmailValidator.IsEmailValid;

@RestController
@CrossOrigin(origins = {"https://elisafarias.netlify.app/", "http://localhost:3000"})
@RequestMapping("/efapi/contactform")
public class ContactFormController {

    @Autowired
    private ContactFormService contactFormService;
    @Autowired
    private EmailService emailService;

    public ContactFormController(ContactFormService contactFormService) {
        this.contactFormService = contactFormService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addContactForm(@RequestBody ContactFormEntity form) {
        URI location = URI.create("addContactFormURIlocation");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        responseHeaders.set("Custom header name", "Custom header value");
        String responseBody;
        // validate email
        if (IsEmailValid(form.getEmail())) {
            // if valid add to db
            contactFormService.addContactForm(form);
            // send confirmation email to user
            responseBody = emailService.sendContactFormConfirmation(form);
            // send notification to elisa
            responseBody += " | " + emailService.sendContactFormNotification(form);
            return new ResponseEntity<String>(responseBody, responseHeaders, HttpStatus.OK);
        }
        // if not valid return response with "email invalid"
        responseBody = "Email validation failed. Check email format and try again.";
        return new ResponseEntity<String>(responseBody, responseHeaders, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ArrayList<ContactFormEntity>> getAllForms() {
        URI location = URI.create("getAllContactFormsURIlocation");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        responseHeaders.set("Custom header name", "Custom header value");
        ArrayList<ContactFormEntity> responseBody = contactFormService.getAllContactForms();
        return new ResponseEntity<>(responseBody, responseHeaders, HttpStatus.OK);
    }
}
