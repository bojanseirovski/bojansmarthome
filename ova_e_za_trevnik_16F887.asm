
_digit1:
;ova_e_za_trevnik_16F887.c,4 :: 		int digit1(int dig)
;ova_e_za_trevnik_16F887.c,6 :: 		switch(dig){
	GOTO       L_digit10
;ova_e_za_trevnik_16F887.c,7 :: 		case 0:PORTD=0x3F;break;
L_digit12:
	MOVLW      63
	MOVWF      PORTD+0
	GOTO       L_digit11
;ova_e_za_trevnik_16F887.c,8 :: 		case 1:PORTD=0x06;break;
L_digit13:
	MOVLW      6
	MOVWF      PORTD+0
	GOTO       L_digit11
;ova_e_za_trevnik_16F887.c,9 :: 		case 2:PORTD=0x5B;break;
L_digit14:
	MOVLW      91
	MOVWF      PORTD+0
	GOTO       L_digit11
;ova_e_za_trevnik_16F887.c,10 :: 		case 3:PORTD=0x4F;break;
L_digit15:
	MOVLW      79
	MOVWF      PORTD+0
	GOTO       L_digit11
;ova_e_za_trevnik_16F887.c,11 :: 		case 4:PORTD=0x66;break;
L_digit16:
	MOVLW      102
	MOVWF      PORTD+0
	GOTO       L_digit11
;ova_e_za_trevnik_16F887.c,12 :: 		case 5:PORTD=0x6D;break;
L_digit17:
	MOVLW      109
	MOVWF      PORTD+0
	GOTO       L_digit11
;ova_e_za_trevnik_16F887.c,13 :: 		case 6:PORTD=0x7D;break;
L_digit18:
	MOVLW      125
	MOVWF      PORTD+0
	GOTO       L_digit11
;ova_e_za_trevnik_16F887.c,14 :: 		case 7:PORTD=0x07;break;
L_digit19:
	MOVLW      7
	MOVWF      PORTD+0
	GOTO       L_digit11
;ova_e_za_trevnik_16F887.c,15 :: 		case 8:PORTD=0x7F;break;
L_digit110:
	MOVLW      127
	MOVWF      PORTD+0
	GOTO       L_digit11
;ova_e_za_trevnik_16F887.c,16 :: 		case 9:PORTD=0x6F;break;
L_digit111:
	MOVLW      111
	MOVWF      PORTD+0
	GOTO       L_digit11
;ova_e_za_trevnik_16F887.c,17 :: 		}
L_digit10:
	MOVLW      0
	XORWF      FARG_digit1_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit156
	MOVLW      0
	XORWF      FARG_digit1_dig+0, 0
L__digit156:
	BTFSC      STATUS+0, 2
	GOTO       L_digit12
	MOVLW      0
	XORWF      FARG_digit1_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit157
	MOVLW      1
	XORWF      FARG_digit1_dig+0, 0
L__digit157:
	BTFSC      STATUS+0, 2
	GOTO       L_digit13
	MOVLW      0
	XORWF      FARG_digit1_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit158
	MOVLW      2
	XORWF      FARG_digit1_dig+0, 0
L__digit158:
	BTFSC      STATUS+0, 2
	GOTO       L_digit14
	MOVLW      0
	XORWF      FARG_digit1_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit159
	MOVLW      3
	XORWF      FARG_digit1_dig+0, 0
L__digit159:
	BTFSC      STATUS+0, 2
	GOTO       L_digit15
	MOVLW      0
	XORWF      FARG_digit1_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit160
	MOVLW      4
	XORWF      FARG_digit1_dig+0, 0
L__digit160:
	BTFSC      STATUS+0, 2
	GOTO       L_digit16
	MOVLW      0
	XORWF      FARG_digit1_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit161
	MOVLW      5
	XORWF      FARG_digit1_dig+0, 0
L__digit161:
	BTFSC      STATUS+0, 2
	GOTO       L_digit17
	MOVLW      0
	XORWF      FARG_digit1_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit162
	MOVLW      6
	XORWF      FARG_digit1_dig+0, 0
L__digit162:
	BTFSC      STATUS+0, 2
	GOTO       L_digit18
	MOVLW      0
	XORWF      FARG_digit1_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit163
	MOVLW      7
	XORWF      FARG_digit1_dig+0, 0
L__digit163:
	BTFSC      STATUS+0, 2
	GOTO       L_digit19
	MOVLW      0
	XORWF      FARG_digit1_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit164
	MOVLW      8
	XORWF      FARG_digit1_dig+0, 0
L__digit164:
	BTFSC      STATUS+0, 2
	GOTO       L_digit110
	MOVLW      0
	XORWF      FARG_digit1_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit165
	MOVLW      9
	XORWF      FARG_digit1_dig+0, 0
L__digit165:
	BTFSC      STATUS+0, 2
	GOTO       L_digit111
L_digit11:
;ova_e_za_trevnik_16F887.c,18 :: 		Delay_ms(200);
	MOVLW      3
	MOVWF      R11+0
	MOVLW      8
	MOVWF      R12+0
	MOVLW      119
	MOVWF      R13+0
L_digit112:
	DECFSZ     R13+0, 1
	GOTO       L_digit112
	DECFSZ     R12+0, 1
	GOTO       L_digit112
	DECFSZ     R11+0, 1
	GOTO       L_digit112
;ova_e_za_trevnik_16F887.c,19 :: 		return 0;
	CLRF       R0+0
	CLRF       R0+1
;ova_e_za_trevnik_16F887.c,20 :: 		}
	RETURN
; end of _digit1

_digit10:
;ova_e_za_trevnik_16F887.c,21 :: 		int digit10(int dig)
;ova_e_za_trevnik_16F887.c,23 :: 		switch(dig){
	GOTO       L_digit1013
;ova_e_za_trevnik_16F887.c,24 :: 		case 0:PORTD=0x3F;break;
L_digit1015:
	MOVLW      63
	MOVWF      PORTD+0
	GOTO       L_digit1014
;ova_e_za_trevnik_16F887.c,25 :: 		case 1:PORTD=0x06;break;
L_digit1016:
	MOVLW      6
	MOVWF      PORTD+0
	GOTO       L_digit1014
;ova_e_za_trevnik_16F887.c,26 :: 		case 2:PORTD=0x5B;break;
L_digit1017:
	MOVLW      91
	MOVWF      PORTD+0
	GOTO       L_digit1014
;ova_e_za_trevnik_16F887.c,27 :: 		case 3:PORTD=0x4F;break;
L_digit1018:
	MOVLW      79
	MOVWF      PORTD+0
	GOTO       L_digit1014
;ova_e_za_trevnik_16F887.c,28 :: 		case 4:PORTD=0x66;break;
L_digit1019:
	MOVLW      102
	MOVWF      PORTD+0
	GOTO       L_digit1014
;ova_e_za_trevnik_16F887.c,29 :: 		case 5:PORTD=0x6D;break;
L_digit1020:
	MOVLW      109
	MOVWF      PORTD+0
	GOTO       L_digit1014
;ova_e_za_trevnik_16F887.c,30 :: 		case 6:PORTD=0x7D;break;
L_digit1021:
	MOVLW      125
	MOVWF      PORTD+0
	GOTO       L_digit1014
;ova_e_za_trevnik_16F887.c,31 :: 		case 7:PORTD=0x07;break;
L_digit1022:
	MOVLW      7
	MOVWF      PORTD+0
	GOTO       L_digit1014
;ova_e_za_trevnik_16F887.c,32 :: 		case 8:PORTD=0x7F;break;
L_digit1023:
	MOVLW      127
	MOVWF      PORTD+0
	GOTO       L_digit1014
;ova_e_za_trevnik_16F887.c,33 :: 		case 9:PORTD=0x6F;break;
L_digit1024:
	MOVLW      111
	MOVWF      PORTD+0
	GOTO       L_digit1014
;ova_e_za_trevnik_16F887.c,34 :: 		}
L_digit1013:
	MOVLW      0
	XORWF      FARG_digit10_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit1066
	MOVLW      0
	XORWF      FARG_digit10_dig+0, 0
L__digit1066:
	BTFSC      STATUS+0, 2
	GOTO       L_digit1015
	MOVLW      0
	XORWF      FARG_digit10_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit1067
	MOVLW      1
	XORWF      FARG_digit10_dig+0, 0
L__digit1067:
	BTFSC      STATUS+0, 2
	GOTO       L_digit1016
	MOVLW      0
	XORWF      FARG_digit10_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit1068
	MOVLW      2
	XORWF      FARG_digit10_dig+0, 0
L__digit1068:
	BTFSC      STATUS+0, 2
	GOTO       L_digit1017
	MOVLW      0
	XORWF      FARG_digit10_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit1069
	MOVLW      3
	XORWF      FARG_digit10_dig+0, 0
L__digit1069:
	BTFSC      STATUS+0, 2
	GOTO       L_digit1018
	MOVLW      0
	XORWF      FARG_digit10_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit1070
	MOVLW      4
	XORWF      FARG_digit10_dig+0, 0
L__digit1070:
	BTFSC      STATUS+0, 2
	GOTO       L_digit1019
	MOVLW      0
	XORWF      FARG_digit10_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit1071
	MOVLW      5
	XORWF      FARG_digit10_dig+0, 0
L__digit1071:
	BTFSC      STATUS+0, 2
	GOTO       L_digit1020
	MOVLW      0
	XORWF      FARG_digit10_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit1072
	MOVLW      6
	XORWF      FARG_digit10_dig+0, 0
L__digit1072:
	BTFSC      STATUS+0, 2
	GOTO       L_digit1021
	MOVLW      0
	XORWF      FARG_digit10_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit1073
	MOVLW      7
	XORWF      FARG_digit10_dig+0, 0
L__digit1073:
	BTFSC      STATUS+0, 2
	GOTO       L_digit1022
	MOVLW      0
	XORWF      FARG_digit10_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit1074
	MOVLW      8
	XORWF      FARG_digit10_dig+0, 0
L__digit1074:
	BTFSC      STATUS+0, 2
	GOTO       L_digit1023
	MOVLW      0
	XORWF      FARG_digit10_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit1075
	MOVLW      9
	XORWF      FARG_digit10_dig+0, 0
L__digit1075:
	BTFSC      STATUS+0, 2
	GOTO       L_digit1024
L_digit1014:
;ova_e_za_trevnik_16F887.c,35 :: 		Delay_ms(200);
	MOVLW      3
	MOVWF      R11+0
	MOVLW      8
	MOVWF      R12+0
	MOVLW      119
	MOVWF      R13+0
L_digit1025:
	DECFSZ     R13+0, 1
	GOTO       L_digit1025
	DECFSZ     R12+0, 1
	GOTO       L_digit1025
	DECFSZ     R11+0, 1
	GOTO       L_digit1025
;ova_e_za_trevnik_16F887.c,36 :: 		return 0;
	CLRF       R0+0
	CLRF       R0+1
;ova_e_za_trevnik_16F887.c,37 :: 		}
	RETURN
; end of _digit10

_digit100:
;ova_e_za_trevnik_16F887.c,38 :: 		int digit100(int dig)
;ova_e_za_trevnik_16F887.c,40 :: 		switch(dig){
	GOTO       L_digit10026
;ova_e_za_trevnik_16F887.c,41 :: 		case 0:PORTD=0x3F;break;
L_digit10028:
	MOVLW      63
	MOVWF      PORTD+0
	GOTO       L_digit10027
;ova_e_za_trevnik_16F887.c,42 :: 		case 1:PORTD=0x06;break;
L_digit10029:
	MOVLW      6
	MOVWF      PORTD+0
	GOTO       L_digit10027
;ova_e_za_trevnik_16F887.c,43 :: 		case 2:PORTD=0x5B;break;
L_digit10030:
	MOVLW      91
	MOVWF      PORTD+0
	GOTO       L_digit10027
;ova_e_za_trevnik_16F887.c,44 :: 		case 3:PORTD=0x4F;break;
L_digit10031:
	MOVLW      79
	MOVWF      PORTD+0
	GOTO       L_digit10027
;ova_e_za_trevnik_16F887.c,45 :: 		case 4:PORTD=0x66;break;
L_digit10032:
	MOVLW      102
	MOVWF      PORTD+0
	GOTO       L_digit10027
;ova_e_za_trevnik_16F887.c,46 :: 		case 5:PORTD=0x6D;break;
L_digit10033:
	MOVLW      109
	MOVWF      PORTD+0
	GOTO       L_digit10027
;ova_e_za_trevnik_16F887.c,47 :: 		case 6:PORTD=0x7D;break;
L_digit10034:
	MOVLW      125
	MOVWF      PORTD+0
	GOTO       L_digit10027
;ova_e_za_trevnik_16F887.c,48 :: 		case 7:PORTD=0x07;break;
L_digit10035:
	MOVLW      7
	MOVWF      PORTD+0
	GOTO       L_digit10027
;ova_e_za_trevnik_16F887.c,49 :: 		case 8:PORTD=0x7F;break;
L_digit10036:
	MOVLW      127
	MOVWF      PORTD+0
	GOTO       L_digit10027
;ova_e_za_trevnik_16F887.c,50 :: 		case 9:PORTD=0x6F;break;
L_digit10037:
	MOVLW      111
	MOVWF      PORTD+0
	GOTO       L_digit10027
;ova_e_za_trevnik_16F887.c,51 :: 		}
L_digit10026:
	MOVLW      0
	XORWF      FARG_digit100_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit10076
	MOVLW      0
	XORWF      FARG_digit100_dig+0, 0
L__digit10076:
	BTFSC      STATUS+0, 2
	GOTO       L_digit10028
	MOVLW      0
	XORWF      FARG_digit100_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit10077
	MOVLW      1
	XORWF      FARG_digit100_dig+0, 0
L__digit10077:
	BTFSC      STATUS+0, 2
	GOTO       L_digit10029
	MOVLW      0
	XORWF      FARG_digit100_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit10078
	MOVLW      2
	XORWF      FARG_digit100_dig+0, 0
L__digit10078:
	BTFSC      STATUS+0, 2
	GOTO       L_digit10030
	MOVLW      0
	XORWF      FARG_digit100_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit10079
	MOVLW      3
	XORWF      FARG_digit100_dig+0, 0
L__digit10079:
	BTFSC      STATUS+0, 2
	GOTO       L_digit10031
	MOVLW      0
	XORWF      FARG_digit100_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit10080
	MOVLW      4
	XORWF      FARG_digit100_dig+0, 0
L__digit10080:
	BTFSC      STATUS+0, 2
	GOTO       L_digit10032
	MOVLW      0
	XORWF      FARG_digit100_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit10081
	MOVLW      5
	XORWF      FARG_digit100_dig+0, 0
L__digit10081:
	BTFSC      STATUS+0, 2
	GOTO       L_digit10033
	MOVLW      0
	XORWF      FARG_digit100_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit10082
	MOVLW      6
	XORWF      FARG_digit100_dig+0, 0
L__digit10082:
	BTFSC      STATUS+0, 2
	GOTO       L_digit10034
	MOVLW      0
	XORWF      FARG_digit100_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit10083
	MOVLW      7
	XORWF      FARG_digit100_dig+0, 0
L__digit10083:
	BTFSC      STATUS+0, 2
	GOTO       L_digit10035
	MOVLW      0
	XORWF      FARG_digit100_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit10084
	MOVLW      8
	XORWF      FARG_digit100_dig+0, 0
L__digit10084:
	BTFSC      STATUS+0, 2
	GOTO       L_digit10036
	MOVLW      0
	XORWF      FARG_digit100_dig+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__digit10085
	MOVLW      9
	XORWF      FARG_digit100_dig+0, 0
L__digit10085:
	BTFSC      STATUS+0, 2
	GOTO       L_digit10037
L_digit10027:
;ova_e_za_trevnik_16F887.c,52 :: 		Delay_ms(200);
	MOVLW      3
	MOVWF      R11+0
	MOVLW      8
	MOVWF      R12+0
	MOVLW      119
	MOVWF      R13+0
L_digit10038:
	DECFSZ     R13+0, 1
	GOTO       L_digit10038
	DECFSZ     R12+0, 1
	GOTO       L_digit10038
	DECFSZ     R11+0, 1
	GOTO       L_digit10038
;ova_e_za_trevnik_16F887.c,53 :: 		return 0;
	CLRF       R0+0
	CLRF       R0+1
;ova_e_za_trevnik_16F887.c,54 :: 		}
	RETURN
; end of _digit100

_cifri:
;ova_e_za_trevnik_16F887.c,55 :: 		int cifri(int f){
;ova_e_za_trevnik_16F887.c,57 :: 		dig1=(f%10);
	MOVLW      10
	MOVWF      R4+0
	MOVLW      0
	MOVWF      R4+1
	MOVF       FARG_cifri_f+0, 0
	MOVWF      R0+0
	MOVF       FARG_cifri_f+1, 0
	MOVWF      R0+1
	CALL       _Div_16x16_S+0
	MOVF       R8+0, 0
	MOVWF      R0+0
	MOVF       R8+1, 0
	MOVWF      R0+1
	MOVF       R0+0, 0
	MOVWF      cifri_dig1_L0+0
	MOVF       R0+1, 0
	MOVWF      cifri_dig1_L0+1
;ova_e_za_trevnik_16F887.c,58 :: 		f=f/10;
	MOVLW      10
	MOVWF      R4+0
	MOVLW      0
	MOVWF      R4+1
	MOVF       FARG_cifri_f+0, 0
	MOVWF      R0+0
	MOVF       FARG_cifri_f+1, 0
	MOVWF      R0+1
	CALL       _Div_16x16_S+0
	MOVF       R0+0, 0
	MOVWF      FARG_cifri_f+0
	MOVF       R0+1, 0
	MOVWF      FARG_cifri_f+1
;ova_e_za_trevnik_16F887.c,59 :: 		dig10=f%10;
	MOVLW      10
	MOVWF      R4+0
	MOVLW      0
	MOVWF      R4+1
	CALL       _Div_16x16_S+0
	MOVF       R8+0, 0
	MOVWF      R0+0
	MOVF       R8+1, 0
	MOVWF      R0+1
	MOVF       R0+0, 0
	MOVWF      cifri_dig10_L0+0
	MOVF       R0+1, 0
	MOVWF      cifri_dig10_L0+1
;ova_e_za_trevnik_16F887.c,60 :: 		f=f/10;
	MOVLW      10
	MOVWF      R4+0
	MOVLW      0
	MOVWF      R4+1
	MOVF       FARG_cifri_f+0, 0
	MOVWF      R0+0
	MOVF       FARG_cifri_f+1, 0
	MOVWF      R0+1
	CALL       _Div_16x16_S+0
	MOVF       R0+0, 0
	MOVWF      FARG_cifri_f+0
	MOVF       R0+1, 0
	MOVWF      FARG_cifri_f+1
;ova_e_za_trevnik_16F887.c,61 :: 		dig100=f%10;
	MOVLW      10
	MOVWF      R4+0
	MOVLW      0
	MOVWF      R4+1
	CALL       _Div_16x16_S+0
	MOVF       R8+0, 0
	MOVWF      R0+0
	MOVF       R8+1, 0
	MOVWF      R0+1
	MOVF       R0+0, 0
	MOVWF      cifri_dig100_L0+0
	MOVF       R0+1, 0
	MOVWF      cifri_dig100_L0+1
;ova_e_za_trevnik_16F887.c,62 :: 		for(i=0;i<4;i++){
	CLRF       _i+0
L_cifri39:
	MOVLW      4
	SUBWF      _i+0, 0
	BTFSC      STATUS+0, 0
	GOTO       L_cifri40
;ova_e_za_trevnik_16F887.c,63 :: 		PORTA=8;
	MOVLW      8
	MOVWF      PORTA+0
;ova_e_za_trevnik_16F887.c,64 :: 		digit100(dig100);
	MOVF       cifri_dig100_L0+0, 0
	MOVWF      FARG_digit100_dig+0
	MOVF       cifri_dig100_L0+1, 0
	MOVWF      FARG_digit100_dig+1
	CALL       _digit100+0
;ova_e_za_trevnik_16F887.c,65 :: 		PORTA=4;
	MOVLW      4
	MOVWF      PORTA+0
;ova_e_za_trevnik_16F887.c,66 :: 		digit10(dig10);
	MOVF       cifri_dig10_L0+0, 0
	MOVWF      FARG_digit10_dig+0
	MOVF       cifri_dig10_L0+1, 0
	MOVWF      FARG_digit10_dig+1
	CALL       _digit10+0
;ova_e_za_trevnik_16F887.c,67 :: 		PORTA=2;
	MOVLW      2
	MOVWF      PORTA+0
;ova_e_za_trevnik_16F887.c,68 :: 		digit1(dig1);
	MOVF       cifri_dig1_L0+0, 0
	MOVWF      FARG_digit1_dig+0
	MOVF       cifri_dig1_L0+1, 0
	MOVWF      FARG_digit1_dig+1
	CALL       _digit1+0
;ova_e_za_trevnik_16F887.c,62 :: 		for(i=0;i<4;i++){
	INCF       _i+0, 1
;ova_e_za_trevnik_16F887.c,69 :: 		}
	GOTO       L_cifri39
L_cifri40:
;ova_e_za_trevnik_16F887.c,70 :: 		return 0;
	CLRF       R0+0
	CLRF       R0+1
;ova_e_za_trevnik_16F887.c,71 :: 		}
	RETURN
; end of _cifri

_interrupt:
	MOVWF      R15+0
	SWAPF      STATUS+0, 0
	CLRF       STATUS+0
	MOVWF      ___saveSTATUS+0
	MOVF       PCLATH+0, 0
	MOVWF      ___savePCLATH+0
	CLRF       PCLATH+0
;ova_e_za_trevnik_16F887.c,74 :: 		void interrupt() {
;ova_e_za_trevnik_16F887.c,75 :: 		j=UART1_Read();
	CALL       _UART1_Read+0
	MOVF       R0+0, 0
	MOVWF      _j+0
;ova_e_za_trevnik_16F887.c,76 :: 		if (j==111)
	MOVF       R0+0, 0
	XORLW      111
	BTFSS      STATUS+0, 2
	GOTO       L_interrupt42
;ova_e_za_trevnik_16F887.c,77 :: 		Delay_ms(500);
	MOVLW      6
	MOVWF      R11+0
	MOVLW      19
	MOVWF      R12+0
	MOVLW      173
	MOVWF      R13+0
L_interrupt43:
	DECFSZ     R13+0, 1
	GOTO       L_interrupt43
	DECFSZ     R12+0, 1
	GOTO       L_interrupt43
	DECFSZ     R11+0, 1
	GOTO       L_interrupt43
	NOP
	NOP
L_interrupt42:
;ova_e_za_trevnik_16F887.c,78 :: 		j=UART1_Read();
	CALL       _UART1_Read+0
	MOVF       R0+0, 0
	MOVWF      _j+0
;ova_e_za_trevnik_16F887.c,79 :: 		PORTE=PORTE|2;
	BSF        PORTE+0, 1
;ova_e_za_trevnik_16F887.c,80 :: 		if(j==170)
	MOVF       R0+0, 0
	XORLW      170
	BTFSS      STATUS+0, 2
	GOTO       L_interrupt44
;ova_e_za_trevnik_16F887.c,81 :: 		UART1_Write(temperature);
	MOVF       _temperature+0, 0
	MOVWF      FARG_UART1_Write_data_+0
	CALL       _UART1_Write+0
L_interrupt44:
;ova_e_za_trevnik_16F887.c,82 :: 		if(j==250)
	MOVF       _j+0, 0
	XORLW      250
	BTFSS      STATUS+0, 2
	GOTO       L_interrupt45
;ova_e_za_trevnik_16F887.c,83 :: 		UART1_Write(humidity);
	MOVF       _humidity+0, 0
	MOVWF      FARG_UART1_Write_data_+0
	CALL       _UART1_Write+0
L_interrupt45:
;ova_e_za_trevnik_16F887.c,84 :: 		if(j==202)
	MOVF       _j+0, 0
	XORLW      202
	BTFSS      STATUS+0, 2
	GOTO       L_interrupt46
;ova_e_za_trevnik_16F887.c,85 :: 		UART1_Write(pump_state);
	MOVF       _pump_state+0, 0
	MOVWF      FARG_UART1_Write_data_+0
	CALL       _UART1_Write+0
L_interrupt46:
;ova_e_za_trevnik_16F887.c,86 :: 		if(j==154)
	MOVF       _j+0, 0
	XORLW      154
	BTFSS      STATUS+0, 2
	GOTO       L_interrupt47
;ova_e_za_trevnik_16F887.c,87 :: 		UART1_Write(flow);
	MOVF       _flow+0, 0
	MOVWF      FARG_UART1_Write_data_+0
	CALL       _UART1_Write+0
L_interrupt47:
;ova_e_za_trevnik_16F887.c,88 :: 		if(j==240){//pump on-off
	MOVF       _j+0, 0
	XORLW      240
	BTFSS      STATUS+0, 2
	GOTO       L_interrupt48
;ova_e_za_trevnik_16F887.c,89 :: 		PORTE=((~PORTE)<<7)>>7;
	COMF       PORTE+0, 0
	MOVWF      R1+0
	MOVLW      7
	MOVWF      R0+0
	MOVF       R1+0, 0
	MOVWF      R3+0
	CLRF       R3+1
	MOVF       R0+0, 0
L__interrupt87:
	BTFSC      STATUS+0, 2
	GOTO       L__interrupt88
	RLF        R3+0, 1
	RLF        R3+1, 1
	BCF        R3+0, 0
	ADDLW      255
	GOTO       L__interrupt87
L__interrupt88:
	MOVLW      7
	MOVWF      R2+0
	MOVF       R3+0, 0
	MOVWF      R0+0
	MOVF       R3+1, 0
	MOVWF      R0+1
	MOVF       R2+0, 0
L__interrupt89:
	BTFSC      STATUS+0, 2
	GOTO       L__interrupt90
	RRF        R0+1, 1
	RRF        R0+0, 1
	BCF        R0+1, 7
	ADDLW      255
	GOTO       L__interrupt89
L__interrupt90:
	MOVF       R0+0, 0
	MOVWF      PORTE+0
;ova_e_za_trevnik_16F887.c,90 :: 		}
L_interrupt48:
;ova_e_za_trevnik_16F887.c,91 :: 		PORTE=PORTE&1;
	MOVLW      1
	ANDWF      PORTE+0, 1
;ova_e_za_trevnik_16F887.c,92 :: 		}
L__interrupt86:
	MOVF       ___savePCLATH+0, 0
	MOVWF      PCLATH+0
	SWAPF      ___saveSTATUS+0, 0
	MOVWF      STATUS+0
	SWAPF      R15+0, 1
	SWAPF      R15+0, 0
	RETFIE
; end of _interrupt

_main:
;ova_e_za_trevnik_16F887.c,95 :: 		void main() {
;ova_e_za_trevnik_16F887.c,96 :: 		ANSEL  = 0x11;
	MOVLW      17
	MOVWF      ANSEL+0
;ova_e_za_trevnik_16F887.c,97 :: 		ANSELH = 0;                 // Configure other AN pins as digital I/O
	CLRF       ANSELH+0
;ova_e_za_trevnik_16F887.c,98 :: 		TRISA= 0x21;
	MOVLW      33
	MOVWF      TRISA+0
;ova_e_za_trevnik_16F887.c,99 :: 		TRISB=TRISD=0;                // PORTD is output
	CLRF       TRISD+0
	MOVF       TRISD+0, 0
	MOVWF      TRISB+0
;ova_e_za_trevnik_16F887.c,100 :: 		TRISC=0xFF;
	MOVLW      255
	MOVWF      TRISC+0
;ova_e_za_trevnik_16F887.c,101 :: 		PORTC=0;
	CLRF       PORTC+0
;ova_e_za_trevnik_16F887.c,102 :: 		PORTB=PORTD=PORTE=0;
	CLRF       PORTE+0
	MOVF       PORTE+0, 0
	MOVWF      PORTD+0
	MOVF       PORTD+0, 0
	MOVWF      PORTB+0
;ova_e_za_trevnik_16F887.c,103 :: 		UART1_init(9600);
	MOVLW      51
	MOVWF      SPBRG+0
	BSF        TXSTA+0, 2
	CALL       _UART1_Init+0
;ova_e_za_trevnik_16F887.c,104 :: 		while(1) {
L_main49:
;ova_e_za_trevnik_16F887.c,105 :: 		pump_state=(PORTE<<3)>>3;//read the pump state
	MOVLW      3
	MOVWF      R0+0
	MOVF       PORTE+0, 0
	MOVWF      R3+0
	CLRF       R3+1
	MOVF       R0+0, 0
L__main91:
	BTFSC      STATUS+0, 2
	GOTO       L__main92
	RLF        R3+0, 1
	RLF        R3+1, 1
	BCF        R3+0, 0
	ADDLW      255
	GOTO       L__main91
L__main92:
	MOVF       R3+0, 0
	MOVWF      R0+0
	MOVF       R3+1, 0
	MOVWF      R0+1
	RRF        R0+1, 1
	RRF        R0+0, 1
	BCF        R0+1, 7
	RRF        R0+1, 1
	RRF        R0+0, 1
	BCF        R0+1, 7
	RRF        R0+1, 1
	RRF        R0+0, 1
	BCF        R0+1, 7
	MOVF       R0+0, 0
	MOVWF      _pump_state+0
;ova_e_za_trevnik_16F887.c,106 :: 		Ow_Reset(&PORTE,2);            // Onewire reset signal
	MOVLW      PORTE+0
	MOVWF      FARG_Ow_Reset_port+0
	MOVLW      2
	MOVWF      FARG_Ow_Reset_pin+0
	CALL       _Ow_Reset+0
;ova_e_za_trevnik_16F887.c,107 :: 		Ow_Write(&PORTE,2,0xCC);       // Issue command SKIP_ROM
	MOVLW      PORTE+0
	MOVWF      FARG_Ow_Write_port+0
	MOVLW      2
	MOVWF      FARG_Ow_Write_pin+0
	MOVLW      204
	MOVWF      FARG_Ow_Write_data_+0
	CALL       _Ow_Write+0
;ova_e_za_trevnik_16F887.c,108 :: 		Ow_Write(&PORTE,2,0x44);       // Issue command CONVERT_T
	MOVLW      PORTE+0
	MOVWF      FARG_Ow_Write_port+0
	MOVLW      2
	MOVWF      FARG_Ow_Write_pin+0
	MOVLW      68
	MOVWF      FARG_Ow_Write_data_+0
	CALL       _Ow_Write+0
;ova_e_za_trevnik_16F887.c,109 :: 		Delay_us(120);
	MOVLW      79
	MOVWF      R13+0
L_main51:
	DECFSZ     R13+0, 1
	GOTO       L_main51
	NOP
	NOP
;ova_e_za_trevnik_16F887.c,110 :: 		Ow_Reset(&PORTE,2);
	MOVLW      PORTE+0
	MOVWF      FARG_Ow_Reset_port+0
	MOVLW      2
	MOVWF      FARG_Ow_Reset_pin+0
	CALL       _Ow_Reset+0
;ova_e_za_trevnik_16F887.c,111 :: 		Ow_Write(&PORTE,2,0xCC);       // Issue command SKIP_ROM
	MOVLW      PORTE+0
	MOVWF      FARG_Ow_Write_port+0
	MOVLW      2
	MOVWF      FARG_Ow_Write_pin+0
	MOVLW      204
	MOVWF      FARG_Ow_Write_data_+0
	CALL       _Ow_Write+0
;ova_e_za_trevnik_16F887.c,112 :: 		Ow_Write(&PORTE,2,0xBE);       // Issue command READ_SCRATCHPAD
	MOVLW      PORTE+0
	MOVWF      FARG_Ow_Write_port+0
	MOVLW      2
	MOVWF      FARG_Ow_Write_pin+0
	MOVLW      190
	MOVWF      FARG_Ow_Write_data_+0
	CALL       _Ow_Write+0
;ova_e_za_trevnik_16F887.c,113 :: 		temperature=Ow_Read(&PORTE,2);
	MOVLW      PORTE+0
	MOVWF      FARG_Ow_Read_port+0
	MOVLW      2
	MOVWF      FARG_Ow_Read_pin+0
	CALL       _Ow_Read+0
	MOVF       R0+0, 0
	MOVWF      _temperature+0
;ova_e_za_trevnik_16F887.c,114 :: 		temperature=(Ow_Read(&PORTE,2)<<8)+temperature;//read the temperature
	MOVLW      PORTE+0
	MOVWF      FARG_Ow_Read_port+0
	MOVLW      2
	MOVWF      FARG_Ow_Read_pin+0
	CALL       _Ow_Read+0
	CLRF       R1+0
	MOVF       _temperature+0, 0
	ADDWF      R1+0, 1
	MOVF       R1+0, 0
	MOVWF      _temperature+0
;ova_e_za_trevnik_16F887.c,115 :: 		temper1=((temperature<<1)>>1)*0.48;
	MOVF       R1+0, 0
	MOVWF      R3+0
	CLRF       R3+1
	RLF        R3+0, 1
	RLF        R3+1, 1
	BCF        R3+0, 0
	MOVF       R3+0, 0
	MOVWF      R0+0
	MOVF       R3+1, 0
	MOVWF      R0+1
	RRF        R0+1, 1
	RRF        R0+0, 1
	BCF        R0+1, 7
	CALL       _Word2Double+0
	MOVLW      143
	MOVWF      R4+0
	MOVLW      194
	MOVWF      R4+1
	MOVLW      117
	MOVWF      R4+2
	MOVLW      125
	MOVWF      R4+3
	CALL       _Mul_32x32_FP+0
	CALL       _Double2Byte+0
	MOVF       R0+0, 0
	MOVWF      _temper1+0
;ova_e_za_trevnik_16F887.c,116 :: 		humidity= ADC_Read(4)>>2;//read the humidity
	MOVLW      4
	MOVWF      FARG_ADC_Read_channel+0
	CALL       _ADC_Read+0
	MOVF       R0+0, 0
	MOVWF      R2+0
	MOVF       R0+1, 0
	MOVWF      R2+1
	RRF        R2+1, 1
	RRF        R2+0, 1
	BCF        R2+1, 7
	RRF        R2+1, 1
	RRF        R2+0, 1
	BCF        R2+1, 7
	MOVF       R2+0, 0
	MOVWF      _humidity+0
;ova_e_za_trevnik_16F887.c,118 :: 		flow1=((ADC_Read(0)>>2)<<2)*0.35;    //read the flow1 to display
	CLRF       FARG_ADC_Read_channel+0
	CALL       _ADC_Read+0
	MOVF       R0+0, 0
	MOVWF      R3+0
	MOVF       R0+1, 0
	MOVWF      R3+1
	RRF        R3+1, 1
	RRF        R3+0, 1
	BCF        R3+1, 7
	RRF        R3+1, 1
	RRF        R3+0, 1
	BCF        R3+1, 7
	MOVF       R3+0, 0
	MOVWF      R0+0
	MOVF       R3+1, 0
	MOVWF      R0+1
	RLF        R0+0, 1
	RLF        R0+1, 1
	BCF        R0+0, 0
	RLF        R0+0, 1
	RLF        R0+1, 1
	BCF        R0+0, 0
	CALL       _Word2Double+0
	MOVLW      51
	MOVWF      R4+0
	MOVLW      51
	MOVWF      R4+1
	MOVLW      51
	MOVWF      R4+2
	MOVLW      125
	MOVWF      R4+3
	CALL       _Mul_32x32_FP+0
	MOVF       R0+0, 0
	MOVWF      _flow1+0
	MOVF       R0+1, 0
	MOVWF      _flow1+1
	MOVF       R0+2, 0
	MOVWF      _flow1+2
	MOVF       R0+3, 0
	MOVWF      _flow1+3
;ova_e_za_trevnik_16F887.c,119 :: 		flow=ADC_Read(0)>>2;    //read the flow to send
	CLRF       FARG_ADC_Read_channel+0
	CALL       _ADC_Read+0
	MOVF       R0+0, 0
	MOVWF      R2+0
	MOVF       R0+1, 0
	MOVWF      R2+1
	RRF        R2+1, 1
	RRF        R2+0, 1
	BCF        R2+1, 7
	RRF        R2+1, 1
	RRF        R2+0, 1
	BCF        R2+1, 7
	MOVF       R2+0, 0
	MOVWF      _flow+0
;ova_e_za_trevnik_16F887.c,120 :: 		cifri((int)flow1);        //display flow1
	MOVF       _flow1+0, 0
	MOVWF      R0+0
	MOVF       _flow1+1, 0
	MOVWF      R0+1
	MOVF       _flow1+2, 0
	MOVWF      R0+2
	MOVF       _flow1+3, 0
	MOVWF      R0+3
	CALL       _Double2Int+0
	MOVF       R0+0, 0
	MOVWF      FARG_cifri_f+0
	MOVF       R0+1, 0
	MOVWF      FARG_cifri_f+1
	CALL       _cifri+0
;ova_e_za_trevnik_16F887.c,121 :: 		if((temper1>29)&&(humidity<35))
	MOVF       _temper1+0, 0
	SUBLW      29
	BTFSC      STATUS+0, 0
	GOTO       L_main54
	MOVLW      35
	SUBWF      _humidity+0, 0
	BTFSC      STATUS+0, 0
	GOTO       L_main54
L__main55:
;ova_e_za_trevnik_16F887.c,122 :: 		PORTE=PORTE|1;
	BSF        PORTE+0, 0
L_main54:
;ova_e_za_trevnik_16F887.c,123 :: 		}
	GOTO       L_main49
;ova_e_za_trevnik_16F887.c,124 :: 		}
	GOTO       $+0
; end of _main
