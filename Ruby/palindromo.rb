##############################
####  Luis Diego Sánchez  ####
####       11002082       ####
##############################

module Lab1
#######################################################################
#######################################################################
	def palindromo?(s)
		regex_s = /([[a-zA-Z]])/  
		m = regex_s.match(s)  
		resultado = false

		for i in(0..m.length - 1)
			if m[i] == m[m.length - 1 - i]
				resultado = true 
			else  
				break  
			end  
		end 
		return resultado
	end
#######################################################################
#######################################################################
	def cuenta_palabras(s)

		tokens = s.split(' ')
		names = Hash.new
		acc = 1
		tokens  = tokens.sort

		for i in(0..tokens.length-1)
			if tokens[i] == tokens[i+1]
				acc +=1
			else
				names[tokens[i]] = acc
				acc = 1
			end	
		end
		return names
	end	
#######################################################################
#######################################################################
	def hanoi(numero_discos , t_origen, t_alterna, t_destino)

		if numero_discos == 1
				#Caso Base
				puts "Numero de discos es 1 entonces:"
				puts "mover disco de " + t_origen.to_s + "(torre origen)" + " a " + t_destino.to_s + "(Torre Destino)"
			else
				hanoi(numero_discos-1,t_origen,t_destino,t_alterna)
				puts "mover disco de " + t_origen.to_s + "(torre origen)" +  " a " + t_destino.to_s + "(Torre Destino)"
				hanoi(numero_discos-1,t_alterna,t_origen,t_destino)
		end
	end
#######################################################################
#######################################################################
	def sort(array,flag)
		#COPIA del ARRAY
		array_copy = array.dup
		aux = nil

		if flag
			#ASCENDENTE
			while flag do
				flag = false
				for i in(1..array_copy.length-1)
					if array_copy[i-1]>array_copy[i]
						aux = array_copy[i-1]
						array_copy[i-1] = array_copy[i]
						array_copy[i] = aux
						flag = true
					end
				end
			end
		else
			#DESCENDENTE
			flag = true
			while flag do
				flag = false
				for i in(1..array_copy.length-1)
					if array_copy[i-1]<array_copy[i]
						aux = array_copy[i-1]
						array_copy[i-1] = array_copy[i]
						array_copy[i] = aux
						flag = true
					end
				end
			end
		end

		return array_copy
	end
#######################################################################
#######################################################################
	def char_count(str,c)
		aux = 0
		for i in(0..str.length-1)
			if str[i] == c
				aux+=1
			end
		end
		return aux
	end
#######################################################################
#######################################################################
	def atoi(s)
		acc = 0
		length = s.length - 1
		for i in (0..s.length - 1)
			acc = (s[length].to_i * (10**i)) + acc
			length -= 1
		end
		return acc
	end
end
#######################################################################
#######################################################################
class Lab1Test
	include Lab1
end
#######################################################################
#######################################################################
class Dessert
	attr_accessor :name
	attr_accessor :size
	attr_accessor :calories

	def initialize(name, calories)
		@calories=calories
		@name=name
		@size=count
	end

	def healthy?
		if @calories < 200
			return true
		else
			return false
		end
	end

	def delicious?
		return true
	end

	def count
		if @size == nil
			@size =1
		else
			@size +=1
		end
	end
end
#######################################################################
#######################################################################
class JellyBean < Dessert
	attr_accessor :flavor
	def initialize(name, calories, flavor)
      # YOUR CODE HERE
      @name=name
      @calories=calories
      @flavor=flavor
  end

  def delicious?
  	if @flavor == "black licorice"
  		return false
  	else
  		return true
  	end
  end
 end
#######################################################################
#######################################################################
module Action
	def jump
		@distance = rand(4) + 2
		puts "I jumped forward #{@distance} feet!"
	end
end
#######################################################################
#######################################################################
class Rabbit
	include Action

	attr_reader :name

	def initialize(name)
		@name = name
	end

	def run(vel)
		time = 10/vel
		sleep(time)
		puts "ha recorrido 10 metros en t=#{time} segundos."
	end	

end
#######################################################################
#######################################################################
class Cricket
	include Action

	attr_reader :name

	def initialize(name)
		@name = name
	end

	def run(vel)
		time = 10/vel
		sleep(time)
		puts "ha recorrido 10 metros en t=#{time} segundos."
	end

	def chirp
		r = Random.new
		r = r.rand(10...100)
		for i in(0..r)
			puts "Chirp...chirp!!"
		end
	end
end
#######################################################################
#######################################################################
class Computer
    @@users = {}   
    @@files_list = Hash.new

    def initialize username, password
        @username = username
        @password = password
        @files = {}
    end

    def create(name)
    	names = name+".rb"
    	time = Time.now
    	if(!@@files_list.has_key?(names))
    		archivo = File.open(names, 'w') 
    		@@files_list[names]= time.strftime("%d/%m/%Y %H:%M:%S")
    		archivo.close
    		puts "El archivo fue creado"
    	else
    		puts "Error el Archivo ya esta creado"
    	end	
    	return nil
    end

    def ls(tabla = @@files_list)
    	if tabla!=@@files_list
    		if tabla.has_key?("sort") 
    			if tabla.has_value?("asc") 
    				tabla= @@files_list.sort_by {|k,v| k }
    				tabla.each {|key, value| puts "#{key} #{value}" }
    			else
    				if tabla.has_value?("desc") 
    					tabla= @@files_list.sort_by {|k,v| k }.reverse
    					tabla.each {|key, value| puts "#{key} #{value}" }
    				end
    			end
    		else
    			puts tabla
    		end
    	else
    		tabla.each {|key, value| puts "#{key} #{value}" }
    	end
    end

    def rm(name)
    	if(@@files_list.has_key?(name))
    		@@files_list.delete(name)
    		File.delete(name)
    	else
    		puts "Error no existe ese archivo"	
    	end
    	return nil
    end
end

#######################################################################
#############################TESTINGS##################################
#######################################################################
lab = Lab1Test.new
puts "\e[H\e[2J" #Lo utilizo para limpiar pantalla.
#######################################################################
puts "Ejercicio 1.1"
puts lab.palindromo?("$a$e$i$o$u$o$i$e$a$")
#######################################################################
puts "Ejercicio 1.2"
puts lab.cuenta_palabras("papa papa mama mama ping pong ping pong")
#######################################################################
puts "Ejercicio 1.3"
puts "Cuantos discos desea introducir"  
STDOUT.flush  
discos = gets.chomp.to_i  
lab.hanoi(discos,1,3,2)
#######################################################################
puts "Ejercicio 1.4"
#TEST CON EL QUE REALICE LAS PRUEBAS DE MI FUNCION.
array = [1,3,2,7,6,5,9]
print lab.sort(array,true)
#######################################################################
puts "\nEjercicio 1.5"
print "El total de caracteres aparecidos es: "
puts lab.char_count("hola ana banana",'a')	
#######################################################################
puts "Ejercicio 1.6"
puts lab.atoi("1234")
#######################################################################
puts "Ejercicio2"
a=JellyBean.new("diet uva",232,"uva")
p a.delicious?
p a.healthy?
p a.count

b=Dessert.new("pie de queso",190)
c=Dessert.new("pie de limon",200)
p b.delicious?
p b.healthy?
p b.count
########################################################################	
puts "Ejercicio3"
peter = Rabbit.new("Peter")
jiminy = Cricket.new("Jiminy")
peter.run(10)
jiminy.run(11)
jiminy.chirp
########################################################################
puts "\e[H\e[2J" #Lo utilizo para limpiar pantalla.
puts "Ejercicio4"
computer = Computer.new("Luis","pass")
computer.create("test")
computer.create("test2")
computer.create("test3")
hash = Hash.new
hash["sort"] = "desc"
puts computer.ls(hash)
computer.rm("test.rb")
puts computer.ls(hash)