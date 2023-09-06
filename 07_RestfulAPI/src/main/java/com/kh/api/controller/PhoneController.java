package com.kh.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.Phone;
import com.kh.api.service.PhoneService;
import com.kh.api.service.PhoneServiceImpl;

@RestController
public class PhoneController {

	@Autowired
	PhoneServiceImpl phn;

	@GetMapping("/phone")
	public ResponseEntity select() {
		// phone 전체 리스트
		try {
			List<Phone> list = phn.select();
			return new ResponseEntity(list, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/phone/{num}")
	public ResponseEntity select(@PathVariable String num) {

		try {
			Phone phone = phn.select(num);
			return new ResponseEntity(phone, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

	}

	@PostMapping("/phone")
	public ResponseEntity insert(@RequestBody Phone phone) {

		try {
			int ph = phn.insert(phone);
			return new ResponseEntity(ph, HttpStatus.OK);
			// return new ResponseEntity(HttpStatus.OK); 이것도됌
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

	}

	@PutMapping("/phone")
	public ResponseEntity update(@RequestBody Phone phone) {
		try {
			phn.update(phone);
			return new ResponseEntity(HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping("/phone/{num}")
	public ResponseEntity delete(@PathVariable String num) {
		try {
			phn.delete(num);
			return new ResponseEntity(HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

	}

}
