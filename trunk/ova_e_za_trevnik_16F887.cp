#line 1 "D:/java/seminarska/ova_e_za_trevnik_16F887/ova_e_za_trevnik_16F887.c"
char temperature, humidity,flow,j,i,temper1, pump_state=0;
float flow1;

int digit1(int dig)
{
 switch(dig){
case 0:PORTD=0x3F;break;
case 1:PORTD=0x06;break;
case 2:PORTD=0x5B;break;
case 3:PORTD=0x4F;break;
case 4:PORTD=0x66;break;
case 5:PORTD=0x6D;break;
case 6:PORTD=0x7D;break;
case 7:PORTD=0x07;break;
case 8:PORTD=0x7F;break;
case 9:PORTD=0x6F;break;
 }
 Delay_ms(200);
return 0;
}
int digit10(int dig)
{
 switch(dig){
case 0:PORTD=0x3F;break;
case 1:PORTD=0x06;break;
case 2:PORTD=0x5B;break;
case 3:PORTD=0x4F;break;
case 4:PORTD=0x66;break;
case 5:PORTD=0x6D;break;
case 6:PORTD=0x7D;break;
case 7:PORTD=0x07;break;
case 8:PORTD=0x7F;break;
case 9:PORTD=0x6F;break;
 }
 Delay_ms(200);
 return 0;
 }
 int digit100(int dig)
{
 switch(dig){
case 0:PORTD=0x3F;break;
case 1:PORTD=0x06;break;
case 2:PORTD=0x5B;break;
case 3:PORTD=0x4F;break;
case 4:PORTD=0x66;break;
case 5:PORTD=0x6D;break;
case 6:PORTD=0x7D;break;
case 7:PORTD=0x07;break;
case 8:PORTD=0x7F;break;
case 9:PORTD=0x6F;break;
 }
 Delay_ms(200);
 return 0;
 }
int cifri(int f){
int dig1,dig10,dig100;
dig1=(f%10);
f=f/10;
dig10=f%10;
f=f/10;
dig100=f%10;
for(i=0;i<4;i++){
 PORTA=8;
 digit100(dig100);
 PORTA=4;
 digit10(dig10);
 PORTA=2;
 digit1(dig1);
 }
return 0;
}


void interrupt() {
 j=UART1_Read();
 if (j==111)
 Delay_ms(500);
 j=UART1_Read();
 PORTE=PORTE|2;
 if(j==170)
 UART1_Write(temperature);
 if(j==250)
 UART1_Write(humidity);
 if(j==202)
 UART1_Write(pump_state);
 if(j==154)
 UART1_Write(flow);
 if(j==240){
 PORTE=((~PORTE)<<7)>>7;
 }
 PORTE=PORTE&1;
}


void main() {
 ANSEL = 0x11;
 ANSELH = 0;
 TRISA= 0x21;
 TRISB=TRISD=0;
 TRISC=0xFF;
 PORTC=0;
 PORTB=PORTD=PORTE=0;
 UART1_init(9600);
 while(1) {
 pump_state=(PORTE<<3)>>3;
 Ow_Reset(&PORTE,2);
 Ow_Write(&PORTE,2,0xCC);
 Ow_Write(&PORTE,2,0x44);
 Delay_us(120);
 Ow_Reset(&PORTE,2);
 Ow_Write(&PORTE,2,0xCC);
 Ow_Write(&PORTE,2,0xBE);
 temperature=Ow_Read(&PORTE,2);
 temperature=(Ow_Read(&PORTE,2)<<8)+temperature;
 temper1=((temperature<<1)>>1)*0.48;
 humidity= ADC_Read(4)>>2;

 flow1=((ADC_Read(0)>>2)<<2)*0.35;
 flow=ADC_Read(0)>>2;
 cifri((int)flow1);
 if((temper1>29)&&(humidity<35))
 PORTE=PORTE|1;
 }
}
