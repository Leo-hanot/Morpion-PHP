int VictoryConds [ ] [ ] [ ]  =  new  int [ 8 ] [ 3 ] [ 2 ] ;
 
plaque int [ ] [ ]  =  new  int [ 3 ] [ 3 ] ;
croix booléenne =  vrai ;
 
booléen over =  false ;
gagnant int =  0 ;
 
void setup ( )  {
  taille ( 300 , 300 ) ;
  textAlign ( CENTRE, CENTRE ) ;
  textFont ( createFont ( "Arial" , 30 ) ) ;
  int c =  0 ;
  pour  ( int a =  0 ; a <  3 ; a ++ )  {
    pour  ( int b =  0 ; b <  3 ; b ++ )  {
      VictoireConds [ c ] [ b ] [ 0 ]  = a ;
      VictoireConds [ c ] [ b ] [ 1 ]  = b ;
      VictoireConds [ c + 1 ] [ b ] [ 0 ]  = b ;
      VictoireConds [ c + 1 ] [ b ] [ 1 ]  = a ;
    }
    c + = 2 ;
  }
  pour  ( int a =  0 ; a <  3 ; a ++ )  {
    VictoireConds [ 6 ] [ a ] [ 0 ]  = a ;
    VictoireConds [ 6 ] [ a ] [ 1 ]  = a ;
    VictoireConds [ 7 ] [ a ] [ 0 ]  =  2 - a ;
    VictoireConds [ 7 ] [ a ] [ 1 ]  = a ;
  }
  noLoop ( ) ;
}
 
void mousePressed ( )  {
  if  ( ! over )  {
    int X =  int ( sourisX / 100 ) ;
    int Y =  int ( sourisY / 100 ) ;
    if  ( plaque [ X ] [ Y ]  ==  0 )  {
      if  ( croix )  {
        plaque [ X ] [ Y ]  =  1 ;
        croix =  faux ;
      }  else  {
        plaque [ X ] [ Y ]  =  2 ;
        croix =  vrai ;
      }
    }
    testWin ( ) ;
  }  else  {
    pour  ( int x =  0 ; x <  3 ; x ++ )  {
      pour  ( int y =  0 ; y <  3 ; y ++ )  {
        plaque [ x ] [ y ]  =  0 ;
      }
    }
    croix =  vrai ;
    over =  faux ;
    gagnant =  0 ;
  }
  redessiner ( ) ;
}
 
void testWin ( )  {
  pour  ( int i =  0 ; i <  8 ; i ++ )  {
    int c =  0 ;
    pour  ( int j =  0 ; j <  3 ; j ++ )  {
      if  ( plate [ VictoireConds [ i ] [ j ] [ 0 ] ] [ VictoireConds [ i ] [ j ] [ 1 ] ]  ==  1 ) c + = 1 ;
      sinon  if  ( plate [ VictoireConds [ i ] [ j ] [ 0 ] ] [ VictoireConds [ i ] [ j ] [ 1 ] ]  ==  2 ) c - = 1 ;
    }
    si  ( c ==  3 )  {
      over =  vrai ;
      gagnant =  1 ;
      retour ;
    }  sinon  si  ( c ==  - 3 )  {
      over =  vrai ;
      gagnant =  2 ;
      retour ;
    }
  }
  booléen c =  vrai ;
  pour  ( int x =  0 ; x <  3 ; x ++ )  {
    pour  ( int y =  0 ; y <  3 ; y ++ )  {
      si  ( plaque [ x ] [ y ]  ==  0 ) c =  faux ;
    }
  }
  si  ( c ) over =  true ;
}
 
nul tirage ( )  {
  arrière-plan ( 150 ) ;
  noFill ( ) ;
  course ( 100 ) ;
  strokeWeight ( 3 ) ;
  ligne ( 100 , 10 , 100 , hauteur - 10 ) ;
  ligne ( 200 , 10 , 200 , hauteur - 10 ) ;
  ligne ( 10 , 100 , largeur - 10 , 100 ) ;
  ligne ( 10 , 200 , largeur - 10 , 200 ) ;
  pour  ( int x =  0 ; x <  3 ; x ++ )  {
    pour  ( int y =  0 ; y <  3 ; y ++ )  {
      si  ( plaque [ x ] [ y ]  ==  1 )  {
        course ( 200 , 0 , 0 ) ;
        ligne ( 20 + x * 100 , 20 + y * 100 , 80 + x * 100 , 80 + y * 100 ) ;
        ligne ( 20 + x * 100 , 80 + y * 100 , 80 + x * 100 , 20 + y * 100 ) ;
      }  else  if  ( plaque [ x ] [ y ]  ==  2 )  {
        course ( 0 , 0 , 200 ) ;
        ellipse ( 50 + x * 100 , 50 + y * 100 , 60 , 60 ) ;
      }
    }
  }
  noStroke ( ) ;
  if  ( over )  {
    remplir ( 0 , 150 ) ;
    rect ( 0 , 0 , largeur, hauteur ) ;
    if  ( gagnant ==  1 )  {
      remplir ( 255 , 0 , 0 , 50 ) ;
      rect ( 0 , 0 , largeur, hauteur ) ;
      remplir ( 255 , 0 , 0 ) ;
      texte ( "Joueur 1 gagne!" , largeur / 2 , hauteur / 2 ) ;
    }  else  if  ( gagnant ==  2 )  {
      remplir ( 0 , 0 , 255 , 50 ) ;
      rect ( 0 , 0 , largeur, hauteur ) ;
      remplir ( 0 , 0 , 255 ) ;
      texte ( "Joueur 2 gagne!" , largeur / 2 , hauteur / 2 ) ;
    }  else  {
      remplir ( 255 ) ;
      text ( "Match nul ..." , largeur / 2 , hauteur / 2 ) ;
    }
  }  else  {
    if  ( cross ) fill ( 255 , 0 , 0 , 50 ) ;
    sinon remplir ( 0 , 0 , 255 , 50 ) ;
    rect ( 0 , 0 , largeur, hauteur ) ;
  }
}