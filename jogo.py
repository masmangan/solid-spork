""" funcoes para manipulacao de estrelas """

# python -m pip install pygame

# python -m pip install --user pygame

# python -m pip -r requirements.txt

from random import choice, randrange
import sys
import pygame




def create_star(x, y):
	speed = randrange(1, 3)
	size = randrange(1, 3)
	color = [choice([100, 200, 250])] * 3
	return (x, y, speed, size, color)

def draw_star(screen, star):
        """Desenha uma estrela na tela"""
        x, y, speed, size, color = star
        rect = (x, y, size, size)
        screen.fill(color, rect)

def move_star(star):
        """Move uma estrela"""
        x, y, speed, size, color = star
        return (x - speed, y, speed, size, color)


class Sprite(object):
    """Define a game sprite"""

    def __init__(self, image, pos, **kwargs):
        """Initialize a sprite object"""
        self.pos = pos
        self.image = pygame.image.load(image)
        self.speed = kwargs.get('speed', 1)
        self.movement = (0, 0)

    def draw(self, screen, **kwargs):
        """Draw the sprite to the screen"""
        screen.blit(self.image, self.pos)

    def update(self):
        """Update sprite position"""
        x, y = self.pos
        dx, dy = self.movement
        speed = self.speed
        self.pos = (x + dx*speed, y + dy*speed)

    def limits(sled, window):
        """Ensure sprite in within limits"""
        w, h = window
        a, b = self.image.get_size()
        x, y = self.pos
        x = 0 if x < 0 else w - a if x > w - a else x
        y = 0 if y < 0 else h - b if y > h - b else y

pygame.init()

SIZE = WIDTH, HEIGHT = (640, 480)
FPS = 60

fullscreen = pygame.FULLSCREEN if ("-fs" is sys.argv) else 0
screen = pygame.display.set_mode(SIZE, fullscreen)
running = True


protagonista = Sprite('media/images/f18.png', (50, HEIGHT//2), speed=3)

starfield = [create_star(randrange(0, WIDTH-1), randrange(0, HEIGHT-1))
             for _ in range(300)]
#starfield = [create_star(randrange(0, WIDTH - 1), randrange(0, HEIGTH - 1)
#                         for _ in range(300)]

while running:
    # Trata eventos
    for event in pygame.event.get():
        if event.type == pygame.QUIT: # Evento de "fechar aplicacao"
            running = False
            break
        elif event.type in [pygame.KEYUP, pygame.KEYDOWN]:  # Evento de teclado
            if event.key == pygame.K_ESCAPE:
                running = False
                break
    # Se o jogo ainda continua...
    if running:
        #desenha objetos
        for star in starfield:
            draw_star(screen, star)
        pygame.display.flip()
        # manipula objetos
# finalizear o sistema
print("Nao desista! Volte logo!")

#
#
#starfield = [move_star(star)
#                 if star[0] > 0
#                 else create_star(WIDTH-1, randrange(0, WEIGTH - 1))
#                 for star in starfield]












