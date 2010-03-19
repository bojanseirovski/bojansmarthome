unsigned int temp, humidity,flow,i;
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


void main() {
  ANSEL  = 0x11;
  ANSELH = 0;                 // Configure other AN pins as digital I/O
  TRISA= 0x21;
  TRISB=TRISD=0;                // PORTD is output
  TRISC=0xFF;
  PORTC=0;
  PORTB=PORTD=0;
  UART1_init(19200);
  do {
    UART1_Write(0xFF);

    Ow_Reset(&PORTE,2);            // Onewire reset signal
    Ow_Write(&PORTE,2,0xCC);       // Issue command SKIP_ROM
    Ow_Write(&PORTE,2,0x44);       // Issue command CONVERT_T
    Delay_us(120);
    Ow_Reset(&PORTE,2);
    Ow_Write(&PORTE,2,0xCC);       // Issue command SKIP_ROM
    Ow_Write(&PORTE,2,0xBE);       // Issue command READ_SCRATCHPAD
    temp=Ow_Read(&PORTE,2);
    temp=(Ow_Read(&PORTE,2)<<8)+temp;//read the temperature
    UART1_Write(temp);
    Delay_ms(500);

    humidity= ADC_Read(4);//read the humidity
    UART1_Write(humidity>>2);
    Delay_ms(500);

    flow1=(ADC_Read(0)>>2)<<2;    //read the flow1
    flow1=(flow1*0.35);
    flow1=flow1-(int)flow1%10;
    flow=ADC_Read(0)>>2;    //read the flow
    UART1_Write(flow);
    cifri((int)flow1);
    Delay_ms(500);

  } while(1);
}

