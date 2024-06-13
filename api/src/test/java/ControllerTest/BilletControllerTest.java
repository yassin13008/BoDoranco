package ControllerTest;

import com.example.api.controllers.BilletController;
import com.example.api.model.Billet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class BilletControllerTest {

    @InjectMocks
    private BilletController billetController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



}
