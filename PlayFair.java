import java.awt.*;
public class PlayFair {   
private String key="Monarchy";
private char[] keyarraay=key.toUpperCase().toCharArray();
private char[] alpha={'A','B','C','D','E','F','G','H','I','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
char[][] matrix=new char[5][5];
StringBuffer buffer=new StringBuffer();
public PlayFair(){
int j=0,k=0;
for (int i=0;i<keyarraay.length;i++){
if(k!=5){
if(!check(keyarraay[i])){
matrix[j][k++]=keyarraay[i];
}
}else {
i--;
k=0;
j++;
}
}
for (int i=0;i<alpha.length;i++){
if(k!=5){
if(!check(alpha[i])){
matrix[j][k++]=alpha[i];
}
}else {
i--;
k=0;j++;
}
}
}
//  function to view matrix   
public void show(){
for (int i=0;i<5;i++) {
for (int j = 0; j < 5; j++) {
System.out.print(matrix[i][j]);
}
System.out.println();
}
}
// function to check for duplicate characters   
private boolean check(char a){
for (int i=0;i<5;i++) {
for (int j = 0; j < 5; j++) {
if(matrix[i][j]==a){
return true;
}
}
}
return false;
}
// function to encrypt   
public String encrypt(String msg){
msg=msg.toUpperCase();
msg=msg.replaceAll(" ","");
msg=msg.replaceAll("J","I");
if(msg.length()%2!=0){
msg=msg.concat("X");
}
char[] msgs=msg.toCharArray();
for (int i=0;i<msgs.length;i++){
Point x1=find(msgs[i++]);
Point x2=find(msgs[i]);
if(x1.x==x2.x){
//same row            
if(x1.y+1==5){
x1.y=0;
}
else {
x1.y++;
}
if(x2.y+1==5){
x2.y=0;
}else {
x2.y++;
}
buffer.append(matrix[x1.x][x1.y]);
buffer.append(matrix[x2.x][x2.y]);
}else if(x1.y==x2.y){
//same column            
if(x1.x+1==5){
x1.x=0;
}
else {
x1.x++;
}
if(x2.x+1==5){
x2.x=0;
}else {
x2.x++;
}
buffer.append(matrix[x1.x][x1.y]);
buffer.append(matrix[x2.x][x2.y]);
}else{
//diagonal            
if(x2.x>x1.x) {
int d=x2.x-x1.x;
x2.x=x2.x-d;
x1.x=x1.x+d;
}else{
int d=x1.x-x2.x;
x2.x=x2.x+d;
x1.x=x1.x-d;
}
buffer.append(matrix[x2.x][x2.y]);
buffer.append(matrix[x1.x][x1.y]);
}
}
return buffer.toString();
}
// function to decrypt   
public String decrypt(String msg){
buffer.delete(0,buffer.length());
msg=msg.toUpperCase();
char[] msgs=msg.toCharArray();
for (int i=0;i<msgs.length;i++){
Point x1=find(msgs[i++]);
Point x2=find(msgs[i]);
if(x1.x==x2.x){   //same row            
if(x1.y-1<0){
x1.y=4;
}
else {
x1.y--;
}
if(x2.y-1<0){
x2.y=4;
}else {
x2.y--;
}
buffer.append(matrix[x1.x][x1.y]);
buffer.append(matrix[x2.x][x2.y]);
}else if(x1.y==x2.y){   //same column
if(x1.x-1<0){
x1.x=4;
}
else {
x1.x--;
}
if(x2.x-1<0){
x2.x=4;
}else {
x2.x--;
}
buffer.append(matrix[x1.x][x1.y]);
buffer.append(matrix[x2.x][x2.y]);
}else{  //diagonal                        
if(x2.x>x1.x) {
int d=x2.x-x1.x;
x2.x=x2.x-d;
x1.x=x1.x+d;
}else{
int d=x1.x-x2.x;
x2.x=x2.x+d;
x1.x=x1.x-d;
}
buffer.append(matrix[x2.x][x2.y]);
buffer.append(matrix[x1.x][x1.y]);
}
}
return buffer.toString();
}
// function  to return positon of character in matrix   
private Point find(char c){
Point p=null;
for (int i=0;i<5;i++) {
for (int j = 0; j < 5; j++) {
if(matrix[i][j]==c){
p=new Point(i,j);
return p;
}
}
}
return p;
}
public static void main(String[]args){
PlayFair playFair=new PlayFair();
String x=playFair.encrypt("balaji");
System.out.println("Cipher : "+x);
System.out.println("Plain  : "+playFair.decrypt(x));
}
}
