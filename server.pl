 #!/usr/bin/perl
 {
 package MyWebServer;
 
 use HTTP::Server::Simple::CGI;
 use base qw(HTTP::Server::Simple::CGI);
use CGI; 
 my %dispatch = (
     '/hello' => \&resp_hello,
	'/cascada' => \&gnah,
	'/meh'=>\&dumdum,
        '/walrus'=>\&datri,
 );
 
 sub handle_request {
     my $self = shift;
     my $cgi  = shift;
   
     my $path = $cgi->path_info();
     my $handler = $dispatch{$path};
 
     if (ref($handler) eq "CODE") {
         print "HTTP/1.0 200 OK\r\n";
         $handler->($cgi);
         
     } else {
         print "HTTP/1.0 404 Not found\r\n";
         print $cgi->header,
               $cgi->start_html('Not found'),
               $cgi->h1('Not found'),
               $cgi->end_html;
     }
 }
 
 sub resp_hello {
     my $cgi  = shift;   # CGI.pm object
     return if !ref $cgi;
     
     my $who = $cgi->param('name');
     
     print $cgi->header,
           $cgi->start_html("Hello"),
           $cgi->h1("Hello $who!"),
           #"<img src='/home/greg/Candice-Swanepoel.jpg'>",
	   $cgi->end_html;
	#system("pwd");
 }

sub gnah{
my $cgi=shift;
return if !ref $cgi;
print $cgi->header,
$cgi->start_html("Cascada"),
$cgi->h1("Want you in my life..."),
$cgi->end_html;
}
sub dumdum{
my $cgi=shift;
return if !ref $cgi;
print "Content-Type: text/html\n\n";
# Note there is a newline between 
# this header and Data

# Simple HTML code follows

print "<html> <head>\n";
print "<title>Perl Server</title>";
print "</head>\n";
print "<body>\n";
print "<h1>Hello from the sexy world of Perl</h1>\n";
print "<img src=https://djstorm.files.wordpress.com/2011/04/candice_swanepoel_36645.jpg width=300>\n";
print "<br>";
print "<h2>with a little help from nginx reverse proxy</h2>\n";
print "<br>";
print "<img src=http://127.0.0.1/candy.jpg width=300>\n";
print "</body> </html>\n";

} 
sub datri{
my $cgi=shift;
return if !ref $cgi;
print "Content-Type: text/html\n\n";
# Note there is a newline between
# this header and Data

# Simple HTML code follows

print "<html> <head>\n";
print "<title>Perl Server</title>";
print "</head>\n";
print "<body>\n";
print "<h1>Since Perl and Java refuse to play nice...</h1>\n";
print "<h1 style=color:red>We brought you a dancing walrus</h1>\n";
print "<br>";
print "<br>";
print "<img src=http://127.0.0.1/walrus.gif width=300>\n";
print "</body> </html>\n";
system("play /home/greg/Downloads/miracle.ogg & echo 'song loaded'");
}

 } 
 
 # start the server on port 8080
 my $pid = MyWebServer->new(8080)->background();
 print "Use 'kill $pid' to stop server.\n";
